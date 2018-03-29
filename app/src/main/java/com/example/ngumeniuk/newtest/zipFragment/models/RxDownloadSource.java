package com.example.ngumeniuk.newtest.zipFragment.models;

import com.esafirm.rxdownloader.RxDownloader;

import javax.inject.Inject;

import io.reactivex.Observable;

public class RxDownloadSource {
    private RxDownloader rxDownloader;

    @Inject
    public RxDownloadSource(RxDownloader rxDownloader) {
        this.rxDownloader = rxDownloader;
    }

    public Observable<String> loadFile(String url){
        return rxDownloader.download(url, "test.zip", true);
    }

}
