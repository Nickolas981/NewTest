package com.example.ngumeniuk.newtest.di.modules;


import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class AppModule {

    private Context context;

    public AppModule(@NonNull Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }


    @Provides
    @Singleton
    Resources provideREcources(){
        return context.getResources();
    }

}
