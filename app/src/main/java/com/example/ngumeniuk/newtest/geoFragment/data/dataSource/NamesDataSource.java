package com.example.ngumeniuk.newtest.geoFragment.data.dataSource;

import com.example.ngumeniuk.newtest.geoFragment.data.models.databaseEntities.CityNameModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface NamesDataSource {
    Flowable<List<CityNameModel>> getAll();
    Completable deleteById(int id);
    Completable putCityName(CityNameModel model);
}
