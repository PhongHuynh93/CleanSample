package com.example.cpu11112_local.cleansample.injection.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by CPU11112-local on 9/11/2017.
 */

public class RepositionModule {
    @Provides
    @Singleton
    SharedPreferences getSharePreference(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }


}
