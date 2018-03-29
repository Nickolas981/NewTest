package com.example.ngumeniuk.newtest.geoFragment.ui;

import com.arellomobile.mvp.MvpView;
import com.example.ngumeniuk.newtest.geoFragment.data.models.databaseEntities.CityNameModel;

import java.util.List;

public interface GeoView extends MvpView{
    void showHints(List<String> list);
    void showNames(List<CityNameModel> list);
}
