package com.example.ngumeniuk.newtest.zipFragment.view;

import com.arellomobile.mvp.MvpView;

import java.io.File;
import java.util.List;

public interface ZipView extends MvpView {
    void showImages(List<File> files);
    void showLoading();
}
