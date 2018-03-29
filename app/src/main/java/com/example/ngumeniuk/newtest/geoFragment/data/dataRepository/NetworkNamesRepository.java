package com.example.ngumeniuk.newtest.geoFragment.data.dataRepository;

import com.example.ngumeniuk.newtest.geoFragment.data.dataSource.NetworkNamesDataSource;
import com.example.ngumeniuk.newtest.geoFragment.data.models.geo.GeoModel;
import com.example.ngumeniuk.newtest.web.GeonamesApi;

import javax.inject.Inject;

import io.reactivex.Observable;

public class NetworkNamesRepository implements NetworkNamesDataSource {

    GeonamesApi api;

    @Inject
    public NetworkNamesRepository(GeonamesApi api) {
        this.api = api;
    }

    @Override
    public Observable<GeoModel> getSearchResult(String phrase) {
        return api.getSearchResult(phrase);
    }
}
