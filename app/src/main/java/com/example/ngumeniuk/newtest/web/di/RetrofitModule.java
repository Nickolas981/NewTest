package com.example.ngumeniuk.newtest.web.di;


import com.example.ngumeniuk.newtest.web.Endpoints;
import com.example.ngumeniuk.newtest.web.GeonamesApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {
    @Singleton
    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Endpoints.GEONAMES_API)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    GeonamesApi provideApi(Retrofit retrofit){
        return retrofit.create(GeonamesApi.class);
    }
}
