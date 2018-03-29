package com.example.ngumeniuk.newtest.geoFragment.data.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ngumeniuk.newtest.geoFragment.data.models.databaseEntities.CityNameModel;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface NamesDao {
    @Insert
    void putName(CityNameModel model);

    @Query("SELECT * FROM names ORDER by id DESC")
    Flowable<List<CityNameModel>> getAll();

    @Query("DELETE FROM names WHERE id LIKE :id")
    void delete(int id);
}
