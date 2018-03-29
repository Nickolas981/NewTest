package com.example.ngumeniuk.newtest.vrFragment.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.ngumeniuk.newtest.R;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ResourceBitmapDataSource implements IBitmapDataSource{

    private Resources resources;

    @Inject
    public ResourceBitmapDataSource(Resources resources) {
        this.resources = resources;
    }

    @Override
    public Observable<Bitmap> getBitmap() {
        return Observable.just(BitmapFactory.decodeResource(resources, R.drawable.vr_image));
    }
}
