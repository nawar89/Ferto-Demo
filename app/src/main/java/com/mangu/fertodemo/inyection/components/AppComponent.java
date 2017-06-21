package com.mangu.fertodemo.inyection.components;

import android.app.Application;
import android.content.Context;


import com.mangu.fertodemo.data.DataManager;
import com.mangu.fertodemo.data.remote.StarterService;
import com.mangu.fertodemo.inyection.AppContext;
import com.mangu.fertodemo.inyection.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @AppContext
    Context context();

    Application application();

    DataManager dataManager();

    StarterService starterService();
}
