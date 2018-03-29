package com.example.ngumeniuk.newtest.vrFragment.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.ngumeniuk.newtest.R;
import com.example.ngumeniuk.newtest.vrFragment.logic.VrPresenter;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VrFragment extends MvpAppCompatFragment implements VrView {

    @BindView(R.id.vr_view)
    VrPanoramaView panoramaView;

    @InjectPresenter
    VrPresenter presenter;

    public VrFragment() {
    }

    public static VrFragment newInstance() {
        return new VrFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vr, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.loadImage();
    }

    @Override
    public void showBitmap(Bitmap bitmap) {
        panoramaView.loadImageFromBitmap(bitmap, null);
    }
}
