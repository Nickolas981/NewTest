package com.example.ngumeniuk.newtest.web;


import com.example.ngumeniuk.newtest.geoFragment.data.models.geo.GeoModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Serhii on 08.02.2018.
 */

public interface GeonamesApi {

    @GET("/searchJSON?username=fbrswat&maxRows=10")
    Observable<GeoModel> getSearchResult(@Query("name_startsWith") String phrase);
}
