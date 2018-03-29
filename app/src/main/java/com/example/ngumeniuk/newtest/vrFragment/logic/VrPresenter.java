package com.example.ngumeniuk.newtest.vrFragment.logic;

import android.graphics.Bitmap;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.ngumeniuk.newtest.App;
import com.example.ngumeniuk.newtest.vrFragment.model.IBitmapDataSource;
import com.example.ngumeniuk.newtest.vrFragment.model.ResourceBitmapDataSource;
import com.example.ngumeniuk.newtest.vrFragment.ui.VrView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


@InjectViewState
public class VrPresenter extends MvpPresenter<VrView> {

    @Inject
    ResourceBitmapDataSource dataSource;

    private Bitmap bitmap = null;

    public VrPresenter() {
        App.appComponent.inject(this);
    }

    public void loadImage() {
        if (bitmap != null){
            getViewState().showBitmap(bitmap);
        }else{
            dataSource.getBitmap()
                    .doOnNext(this::saveBitmap)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(getViewState()::showBitmap);
        }
    }

    private void saveBitmap(Bitmap bitmap){
        this.bitmap = bitmap;
    }
}
