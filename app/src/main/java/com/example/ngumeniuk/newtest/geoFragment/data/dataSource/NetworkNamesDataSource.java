package com.example.ngumeniuk.newtest.geoFragment.data.dataSource;

import com.example.ngumeniuk.newtest.geoFragment.data.models.geo.GeoModel;

import io.reactivex.Observable;

public interface NetworkNamesDataSource {
   Observable<GeoModel> getSearchResult(String phrase);
}
