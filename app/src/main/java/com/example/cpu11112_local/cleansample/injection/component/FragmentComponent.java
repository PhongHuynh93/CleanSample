package com.example.cpu11112_local.cleansample.injection.component;

import com.example.cpu11112_local.cleansample.injection.PerFragment;
import com.example.cpu11112_local.cleansample.injection.module.FragmentModule;

import dagger.Component;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerFragment
@Component(dependencies = MovieComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
}
