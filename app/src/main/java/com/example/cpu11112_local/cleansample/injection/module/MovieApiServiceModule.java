package com.example.cpu11112_local.cleansample.injection.module;

import android.content.Context;

import com.example.cpu11112_local.cleansample.data.remote.MovieRetrofitInstance;

import javax.inject.Singleton;

import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by CPU11112-local on 9/11/2017.
 */

public class MovieApiServiceModule {
    //   retrofit instance
    @Provides
    @Singleton
    public Retrofit provideRetrofitInstance(Context context) {
        return MovieRetrofitInstance.getInstance(context);
    }

    //    retrofit endpoint
    @Provides
    @Singleton
    public MovieRetrofitEndpoint provideSpotifyApiService(Retrofit retrofit) {
        return retrofit.create(MovieRetrofitEndpoint.class);
    }

    //    interact with server
    @Provides
    @Singleton
    public MovieInteractor provideArtistSearchInteractor(MovieRetrofitEndpoint apiService, Context context) {
        return new MovieInteractor(context, apiService);
    }
}
