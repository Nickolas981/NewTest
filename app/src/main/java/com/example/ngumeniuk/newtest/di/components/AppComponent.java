package com.example.ngumeniuk.newtest.di.components;


import com.example.ngumeniuk.newtest.di.modules.AppModule;
import com.example.ngumeniuk.newtest.geoFragment.di.RoomModule;
import com.example.ngumeniuk.newtest.geoFragment.presenter.GeoPresenter;
import com.example.ngumeniuk.newtest.vrFragment.presenter.VrPresenter;
import com.example.ngumeniuk.newtest.web.di.RetrofitModule;
import com.example.ngumeniuk.newtest.zipFragment.presenter.ZipPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class, RetrofitModule.class, RoomModule.class
})
public interface AppComponent{
    void inject(VrPresenter presenter);
    void inject(ZipPresenter presenter);
    void inject(GeoPresenter presenter);
}
