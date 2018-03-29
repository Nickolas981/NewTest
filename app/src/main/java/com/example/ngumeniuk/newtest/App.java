package com.example.ngumeniuk.newtest;

import android.app.Application;

import com.example.ngumeniuk.newtest.di.components.AppComponent;
import com.example.ngumeniuk.newtest.di.components.DaggerAppComponent;
import com.example.ngumeniuk.newtest.di.modules.AppModule;
import com.example.ngumeniuk.newtest.geoFragment.di.RoomModule;

public class App extends Application{

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = buildAppComponent();
    }

    private AppComponent buildAppComponent(){
        return DaggerAppComponent
                .builder()
                .roomModule(new RoomModule(this))
                .appModule(new AppModule(this))
                .build();
    }
}
