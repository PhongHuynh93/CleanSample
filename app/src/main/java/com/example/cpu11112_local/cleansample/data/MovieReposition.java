package com.example.cpu11112_local.cleansample.data;

import com.example.cpu11112_local.cleansample.utils.Constant;

import javax.inject.Named;

/**
 * Created by CPU11112-local on 9/12/2017.
 */
public class MovieReposition implements MovieDataSource {
    private final MovieDataSource mLocalMovieDataSource;
    private final MovieDataSource mRemoteMovieDataSource;

    public MovieReposition(@Named(Constant.MOVIE_LOCAL) MovieDataSource localmovie, @Named(Constant.MOVIE_REMOTE) MovieDataSource remotemovie) {
        mLocalMovieDataSource = localmovie;
        mRemoteMovieDataSource = remotemovie;
    }
}
