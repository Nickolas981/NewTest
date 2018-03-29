package com.example.ngumeniuk.newtest.di.components;


import com.example.ngumeniuk.newtest.di.modules.AppModule;
import com.example.ngumeniuk.newtest.vrFragment.logic.VrPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
})
public interface AppComponent{
    void inject(VrPresenter presenter);
}
