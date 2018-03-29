package com.example.ngumeniuk.newtest.zipFragment.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.ngumeniuk.newtest.R;
import com.example.ngumeniuk.newtest.zipFragment.presenter.ZipPresenter;
import com.example.ngumeniuk.newtest.zipFragment.view.ZipView;
import com.example.ngumeniuk.newtest.zipFragment.widgets.adapters.GridImageAdapter;
import com.jaeger.ninegridimageview.NineGridImageView;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ZipFragment extends MvpAppCompatFragment implements ZipView, View.OnClickListener {

    @BindView(R.id.zip_url)
    EditText zipUrl;
    @BindView(R.id.load_button)
    ImageView loadButton;
    @BindView(R.id.gridview)
    GridView gridImageView;
    @BindView(R.id.loading_view)
    ProgressBar loadingView;

    @InjectPresenter
    ZipPresenter presenter;


    GridImageAdapter adapter;

    public ZipFragment() {

    }

    public static ZipFragment newInstance() {
        return new ZipFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        adapter = new GridImageAdapter(getActivity().getApplicationContext());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_zip, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        gridImageView.setAdapter(adapter);
        loadButton.setOnClickListener(this);
    }

    @Override
    public void showImages(List<File> files) {
        adapter.setList(files);
        gridImageView.setVisibility(View.VISIBLE);
        loadingView.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        gridImageView.setVisibility(View.GONE);
        loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        int id  = v.getId();
        if (id == R.id.load_button){
            presenter.loadImages(zipUrl.getText().toString());
        }
    }
}
