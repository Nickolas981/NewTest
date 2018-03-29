package com.example.ngumeniuk.newtest;

import android.app.Application;

import com.example.ngumeniuk.newtest.di.components.AppComponent;
import com.example.ngumeniuk.newtest.di.components.DaggerAppComponent;
import com.example.ngumeniuk.newtest.di.modules.AppModule;

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
                .appModule(new AppModule(this))
                .build();
    }
}
