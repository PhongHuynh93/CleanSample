package com.example.cpu11112_local.cleansample.data.remote;

import com.example.cpu11112_local.cleansample.data.MovieDataSource;
import com.example.cpu11112_local.cleansample.data.model.DiscoverMovieResponse;

import io.reactivex.Observable;

/**
 * Created by CPU11112-local on 9/12/2017.
 */
public class MovieRemoteDataSource implements MovieDataSource {
    private final MovieRetrofitEndpoint mMovieRetrofitEndpoint;

    public MovieRemoteDataSource(MovieRetrofitEndpoint movieRetrofitEndpoint) {
        this.mMovieRetrofitEndpoint = movieRetrofitEndpoint;
    }

    @Override
    public Observable<DiscoverMovieResponse> getRemoteDatas(String sortBy, Integer page) {
        return mMovieRetrofitEndpoint.discoverMovies(sortBy, page);
    }
}
