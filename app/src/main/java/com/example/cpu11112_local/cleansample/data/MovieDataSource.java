package com.example.cpu11112_local.cleansample.data;

import com.example.cpu11112_local.cleansample.data.model.DiscoverMovieResponse;

import io.reactivex.Observable;

/**
 * Created by CPU11112-local on 9/12/2017.
 */

public interface MovieDataSource {
    Observable<DiscoverMovieResponse> getRemoteDatas(String sortBy, Integer page);
}
