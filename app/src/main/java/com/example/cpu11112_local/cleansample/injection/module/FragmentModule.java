package com.example.cpu11112_local.cleansample.injection.module;

import android.support.v4.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    private final Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    RequestManager providesGlide() {
        return Glide.with(mFragment.getContext());
    }
}
