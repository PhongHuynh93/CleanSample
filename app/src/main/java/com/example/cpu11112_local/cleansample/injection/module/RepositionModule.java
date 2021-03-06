package com.example.cpu11112_local.cleansample.injection.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.cpu11112_local.cleansample.data.MovieDataSource;
import com.example.cpu11112_local.cleansample.data.MovieReposition;
import com.example.cpu11112_local.cleansample.data.local.AppLocalDatabase;
import com.example.cpu11112_local.cleansample.data.local.MovieLocalDataSource;
import com.example.cpu11112_local.cleansample.data.remote.MovieRemoteDataSource;
import com.example.cpu11112_local.cleansample.data.remote.MovieRetrofitEndpoint;
import com.example.cpu11112_local.cleansample.utils.Constant;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by CPU11112-local on 9/11/2017.
 */
@Module
public class RepositionModule {
    @Provides
    @Singleton
    SharedPreferences getSharePreference(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    @Named(Constant.MOVIE_REPOSITION)
    MovieDataSource getMovieReposition(@Named(Constant.MOVIE_LOCAL) MovieDataSource localmovie, @Named(Constant.MOVIE_REMOTE) MovieDataSource remotemovie, AppLocalDatabase appLocalDatabase) {
        return new MovieReposition(localmovie, remotemovie, appLocalDatabase);
    }

    @Provides
    @Singleton
    @Named(Constant.MOVIE_LOCAL)
    MovieDataSource getLocalMovie(Context context) {
        return new MovieLocalDataSource(context);
    }

    @Provides
    @Singleton
    @Named(Constant.MOVIE_REMOTE)
    MovieDataSource getRemoteMovie(MovieRetrofitEndpoint movieRetrofitEndpoint) {
        return new MovieRemoteDataSource(movieRetrofitEndpoint);
    }

    @Provides
    @Singleton
    AppLocalDatabase getAppLocalDatabase(Context context) {
        return AppLocalDatabase.getAppDatabase(context);
    }

}
