package com.example.ngumeniuk.newtest.zipFragment.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.ngumeniuk.newtest.App;
import com.example.ngumeniuk.newtest.utils.Unziper;
import com.example.ngumeniuk.newtest.zipFragment.models.RxDownloadSource;
import com.example.ngumeniuk.newtest.zipFragment.view.ZipView;

import java.io.File;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class ZipPresenter extends MvpPresenter<ZipView>{

    @Inject
    RxDownloadSource downloadSource;
    @Inject
    Unziper unziper;

    private String _url = "";

    public ZipPresenter() {
        App.appComponent.inject(this);
    }

    @SuppressLint("CheckResult")
    public void loadImages(String url){
        if (!_url.equals(url)) {
            getViewState().showLoading();
            _url = url;
            downloadSource.loadFile(url)
                    .map(File::new)
                    .map(file ->  unziper.unzip())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(getViewState()::showImages);
        }
    }

}
