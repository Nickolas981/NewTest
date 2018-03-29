package com.example.ngumeniuk.newtest.geoFragment.data.models.geo;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GeoModel {
    @SerializedName("geonames")
    private List<Geoname> geonames = null;

    public List<Geoname> getGeonames() {
        return geonames;
    }
}
