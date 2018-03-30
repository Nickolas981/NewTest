package com.example.ngumeniuk.newtest.geoFragment.presenter;


import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.ngumeniuk.newtest.App;
import com.example.ngumeniuk.newtest.geoFragment.data.dataRepository.NamesRepository;
import com.example.ngumeniuk.newtest.geoFragment.data.dataRepository.NetworkNamesRepository;
import com.example.ngumeniuk.newtest.geoFragment.data.models.databaseEntities.CityNameModel;
import com.example.ngumeniuk.newtest.geoFragment.data.models.geo.Geoname;
import com.example.ngumeniuk.newtest.geoFragment.ui.GeoView;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class GeoPresenter extends MvpPresenter<GeoView> {

    @Inject
    NetworkNamesRepository networkNamesRepository;
    @Inject
    NamesRepository namesRepository;

    public GeoPresenter() {
        App.appComponent.inject(this);
    }

    @SuppressLint("CheckResult")
    public void loadHints(String str) {
        networkNamesRepository.getSearchResult(str)
                .map(geoModel -> {
                    ArrayList<String> names = new ArrayList<>();
                    for (Geoname name : geoModel.getGeonames()) {
                        names.add(name.getName());
                    }
                    return names;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getViewState()::showHints);
    }


    public void putName(CityNameModel model){
        namesRepository.putCityName(model)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    public void deleteAt(int id){
        namesRepository.deleteById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    @SuppressLint("CheckResult")
    public void getAllNames(){
        namesRepository.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getViewState()::showNames);
    }

    public void delete(CityNameModel model){
        namesRepository.delete(model)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }
}
