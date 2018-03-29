package com.example.ngumeniuk.newtest.di.modules;


import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;


import com.esafirm.rxdownloader.RxDownloader;
import com.example.ngumeniuk.newtest.utils.Unziper;

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
    Resources provideResources(){
        return context.getResources();
    }

    @Provides
    @Singleton
    RxDownloader provideRxDownloader() {return new RxDownloader(context);}

    @Provides
    @Singleton
    Unziper provideUnziper() {return new Unziper(context);}

}
