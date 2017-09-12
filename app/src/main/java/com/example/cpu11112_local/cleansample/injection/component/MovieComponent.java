package com.example.cpu11112_local.cleansample.injection.component;

import com.example.cpu11112_local.cleansample.injection.module.ApplicationModule;
import com.example.cpu11112_local.cleansample.injection.module.FragmentModule;
import com.example.cpu11112_local.cleansample.injection.module.MovieApiServiceModule;
import com.example.cpu11112_local.cleansample.injection.module.RepositionModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by CPU11112-local on 9/11/2017.
 */
@Singleton
@Component(modules = {ApplicationModule.class, RepositionModule.class, MovieApiServiceModule.class})
public interface MovieComponent {
    FragmentComponent newSubFragmentComponent(FragmentModule fragmentModule);
}
