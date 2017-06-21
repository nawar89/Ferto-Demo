package com.mangu.fertodemo.inyection.components;



import com.mangu.fertodemo.inyection.PerActivity;
import com.mangu.fertodemo.inyection.modules.ActivityModule;
import com.mangu.fertodemo.ui.base.BaseActivity;
import com.mangu.fertodemo.ui.main.MainActivity;

import dagger.Subcomponent;

//TODO Never forget this
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(BaseActivity baseActivity);

    void inject(MainActivity mainActivity);

}

