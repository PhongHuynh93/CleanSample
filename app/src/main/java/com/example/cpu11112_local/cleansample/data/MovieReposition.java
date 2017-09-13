package com.example.cpu11112_local.cleansample.data;

import com.example.cpu11112_local.cleansample.data.local.AppLocalDatabase;
import com.example.cpu11112_local.cleansample.data.model.DiscoverMovieResponse;
import com.example.cpu11112_local.cleansample.utils.Constant;

import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by CPU11112-local on 9/12/2017.
 */
public class MovieReposition implements MovieDataSource {
    private final MovieDataSource mLocalMovieDataSource;
    private final MovieDataSource mRemoteMovieDataSource;
    private final AppLocalDatabase mAppLocalDatabase;

    public MovieReposition(@Named(Constant.MOVIE_LOCAL) MovieDataSource localmovie, @Named(Constant.MOVIE_REMOTE) MovieDataSource remotemovie, AppLocalDatabase appLocalDatabase) {
        mLocalMovieDataSource = localmovie;
        mRemoteMovieDataSource = remotemovie;
        mAppLocalDatabase = appLocalDatabase;
    }

    // TODO: 9/12/2017 apply rx here to get from local data when there is no network
    @Override
    public Observable<DiscoverMovieResponse> getRemoteDatas(String sortBy, Integer page) {
        // test: 9/13/2017 save the data into local
        return mRemoteMovieDataSource.getRemoteDatas(sortBy, page)
                .doOnNext(new Consumer<DiscoverMovieResponse>() {
                    @Override
                    public void accept(DiscoverMovieResponse discoverMovieResponse) throws Exception {
                        // save list of data into rooms
                        mAppLocalDatabase.userDao().addDiscoverMovie(discoverMovieResponse.getResults());
                    }
                });
    }
}
