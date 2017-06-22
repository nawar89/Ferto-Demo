package com.mangu.fertodemo.inyection.modules;

import android.app.Application;
import android.content.Context;

import com.mangu.fertodemo.data.remote.StarterService;
import com.mangu.fertodemo.data.remote.StarterServiceFactory;
import com.mangu.fertodemo.inyection.AppContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    static StarterService provideStarterService() {
        return StarterServiceFactory.makeStarterService();
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @AppContext
    Context provideContext() {
        return mApplication;
    }

}
