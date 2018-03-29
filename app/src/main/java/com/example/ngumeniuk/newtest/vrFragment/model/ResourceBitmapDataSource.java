package com.example.ngumeniuk.newtest.vrFragment.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.ngumeniuk.newtest.R;

public class ResourceBitmapDataSource implements IBitmapDataSource{

    private Resources resources;

    public ResourceBitmapDataSource(Resources resources) {
        this.resources = resources;
    }

    @Override
    public Bitmap getBitmap() {
        return BitmapFactory.decodeResource(resources, R.drawable.vr_image);
    }
}
