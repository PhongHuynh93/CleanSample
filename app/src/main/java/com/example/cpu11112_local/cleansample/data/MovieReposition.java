package com.example.cpu11112_local.cleansample.data;

import com.example.cpu11112_local.cleansample.data.model.DiscoverMovieResponse;
import com.example.cpu11112_local.cleansample.utils.Constant;

import javax.inject.Named;

import io.reactivex.Observable;

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

    // TODO: 9/12/2017 apply rx here to get from local data when there is no network
    @Override
    public Observable<DiscoverMovieResponse> getRemoteDatas(String sortBy, Integer page) {
        return mRemoteMovieDataSource.getRemoteDatas(sortBy, page);
    }
}
