package com.example.ngumeniuk.newtest.geoFragment.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ngumeniuk.newtest.R;


public class GeoFragment extends Fragment {


    public GeoFragment() {
        // Required empty public constructor
    }


    public static GeoFragment newInstance() {
        return new GeoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_geo, container, false);
    }

}
