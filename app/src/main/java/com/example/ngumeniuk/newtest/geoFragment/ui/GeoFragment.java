package com.example.ngumeniuk.newtest.geoFragment.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.ngumeniuk.newtest.R;
import com.example.ngumeniuk.newtest.geoFragment.data.models.databaseEntities.CityNameModel;
import com.example.ngumeniuk.newtest.geoFragment.presenter.GeoPresenter;
import com.example.ngumeniuk.newtest.geoFragment.widgets.adapters.GeoNamesListAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GeoFragment extends MvpAppCompatFragment implements GeoView {

    @BindView(R.id.city_name)
    AutoCompleteTextView textView;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @InjectPresenter
    GeoPresenter presenter;

    GeoNamesListAdapter adapter;
    ArrayAdapter<String> hintAdapter;
    private LinearLayoutManager layoutManager;

    public GeoFragment() {
    }


    public static GeoFragment newInstance() {
        return new GeoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new GeoNamesListAdapter();
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_geo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.loadHints(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        textView.setOnItemClickListener((parent, view1, position, id)
                -> {
            presenter.putName(new CityNameModel(hintAdapter.getItem(position)));
        });
        presenter.getAllNames();
    }

    @Override
    public void showHints(List<String> list) {
        hintAdapter = new ArrayAdapter<>(
                Objects.requireNonNull(getActivity().getApplicationContext()),
                android.R.layout.simple_dropdown_item_1line, list);
        textView.setAdapter(hintAdapter);
    }

    @Override
    public void showNames(List<CityNameModel> list) {
        adapter.change((ArrayList<CityNameModel>) list);
    }
}
