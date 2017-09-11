package com.example.cpu11112_local.cleansample.movie;

import android.support.annotation.NonNull;

import com.example.cpu11112_local.cleansample.BasePresenter;
import com.example.cpu11112_local.cleansample.movie.domain.usecase.GetMovieList;

import javax.inject.Inject;

/**
 * Created by CPU11112-local on 9/11/2017.
 */

public class ListMoviePresenter extends BasePresenter<ListMovieView> {
    private final GetMovieList mGetMovieList;

    // TODO: 9/11/2017 add mapper here
    @Inject
    public ListMoviePresenter(@NonNull GetMovieList getMovieList) {
//                              @NonNull ClearCompleteTasks clearCompleteTasks) {
        this.mGetMovieList = getMovieList;
//        this.userModelDataMapper = userModelDataMapper;
    }


}
