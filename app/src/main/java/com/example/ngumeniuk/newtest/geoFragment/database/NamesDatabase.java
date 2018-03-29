package com.example.ngumeniuk.newtest.geoFragment.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.ngumeniuk.newtest.geoFragment.data.dao.NamesDao;
import com.example.ngumeniuk.newtest.geoFragment.data.models.databaseEntities.CityNameModel;

@Database(entities = {CityNameModel.class}, version = 1)
public abstract class NamesDatabase extends RoomDatabase{
    abstract public NamesDao namesDao();
}
