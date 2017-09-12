package com.example.cpu11112_local.cleansample.movie;

import com.example.cpu11112_local.cleansample.MvpView;
import com.example.cpu11112_local.cleansample.data.model.DiscoverMovieResponse;

/**
 * Created by CPU11112-local on 9/11/2017.
 */

public interface ListMovieView extends MvpView {
    void showListMovie(DiscoverMovieResponse discoverMovieResponse);
    void setThePullToRefreshDissappear();
}
