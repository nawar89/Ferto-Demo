package com.mangu.fertodemo.inyection.components;



import com.mangu.fertodemo.inyection.PerFragment;
import com.mangu.fertodemo.inyection.modules.FragmentModule;

import dagger.Subcomponent;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

}