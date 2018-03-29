package com.example.ngumeniuk.newtest.vrFragment.model;

import android.graphics.Bitmap;

import io.reactivex.Observable;

public interface IBitmapDataSource {
    Observable<Bitmap> getBitmap();
}
