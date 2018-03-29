package com.example.ngumeniuk.newtest.geoFragment.data.models.geo;

import com.google.gson.annotations.SerializedName;

public class Geoname {
    @SerializedName("toponymName")
    private String name;

    public String getName() {
        return name;
    }

}
