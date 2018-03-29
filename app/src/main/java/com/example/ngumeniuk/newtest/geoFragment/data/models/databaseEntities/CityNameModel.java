package com.example.ngumeniuk.newtest.geoFragment.data.models.databaseEntities;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.example.ngumeniuk.newtest.utils.Differeble;

import java.util.Objects;

@Entity(tableName = "names")
public class CityNameModel implements Differeble {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    public CityNameModel(String name) {
        this.name = name;
    }

    public CityNameModel() {
    }

    @Override
    public int getIdToDiff() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityNameModel that = (CityNameModel) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public String getName() {
        return name;
    }
}
