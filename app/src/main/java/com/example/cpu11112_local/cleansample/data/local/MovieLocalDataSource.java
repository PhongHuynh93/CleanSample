package com.example.cpu11112_local.cleansample.data.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.cpu11112_local.cleansample.data.MovieDataSource;
import com.example.cpu11112_local.cleansample.data.model.DiscoverMovieResponse;

import io.reactivex.Observable;

/**
 * Created by CPU11112-local on 9/12/2017.
 */
public class MovieLocalDataSource implements MovieDataSource {
    public MovieLocalDataSource(@NonNull Context context) {
//        mDbHelper = new TasksDbHelper(context);
    }

    @Override
    public Observable<DiscoverMovieResponse> getRemoteDatas(String sortBy, Integer page) {
        return null;
    }
}
