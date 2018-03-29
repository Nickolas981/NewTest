package com.example.ngumeniuk.newtest.geoFragment.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.ngumeniuk.newtest.geoFragment.data.dao.NamesDao;
import com.example.ngumeniuk.newtest.geoFragment.database.NamesDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    Context context;

    public RoomModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    NamesDatabase provideWeatherRoomDataBase() {
        return Room.databaseBuilder(context, NamesDatabase.class, "namesDatabase")
                .build();
    }

    @Provides
    @Singleton
    NamesDao provideWeatherDao(NamesDatabase namesDatabase) {
        return namesDatabase.namesDao();
    }


}
