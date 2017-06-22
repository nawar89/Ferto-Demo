package com.mangu.fertodemo.inyection.components;


import com.mangu.fertodemo.inyection.ConfigPersistent;
import com.mangu.fertodemo.inyection.modules.ActivityModule;
import com.mangu.fertodemo.inyection.modules.FragmentModule;

import dagger.Component;

@ConfigPersistent
@Component(dependencies = AppComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);

    FragmentComponent fragmentComponent(FragmentModule fragmentModule);

}
