package com.example.ngumeniuk.newtest.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.inject.Inject;

public class Unziper {

    private Context context;
    private String rootLocation;

    @Inject
    public Unziper(Context context) {
        this.context = context;
        File directory = new File(context.getFilesDir(), "UbrainiansUnZip");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        rootLocation = directory.getAbsolutePath();
    }

    public List<File> unzip() {
        try {
            File zipFile = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS) +"/test.zip");
            InputStream fin = new FileInputStream(zipFile);
            ZipInputStream zin = new ZipInputStream(fin);
            ZipEntry ze = null;
            deleteRecursive(new File(rootLocation));
            while ((ze = zin.getNextEntry()) != null) {

                if (ze.isDirectory()) {
                    _dirChecker(rootLocation + "/" + ze.getName());
                } else {
                    FileOutputStream fout = new FileOutputStream(new File(rootLocation, ze.getName()));
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int count;

                    // reading and writing
                    while ((count = zin.read(buffer)) != -1) {
                        baos.write(buffer, 0, count);
                        byte[] bytes = baos.toByteArray();
                        fout.write(bytes);
                        baos.reset();
                    }

                    fout.close();
                    zin.closeEntry();
                }

            }
            zin.close();
            zin.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listf(rootLocation);
    }

    private void _dirChecker(String dir) {
        File f = new File(dir);
        if (dir.length() >= 0 && !f.isDirectory()) {
            f.mkdirs();
        }
    }

    private ArrayList<File> listf(String directoryName) {
        File directory = new File(directoryName);
        ArrayList<File> files = new ArrayList<>();
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                files.addAll(listf(file.getAbsolutePath()));
            }
        }
        return files;
    }

    void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deleteRecursive(child);

        fileOrDirectory.delete();
    }
}
