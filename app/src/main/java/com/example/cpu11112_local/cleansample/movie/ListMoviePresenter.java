package com.example.cpu11112_local.cleansample.movie;

import android.support.annotation.NonNull;

import com.example.cpu11112_local.cleansample.BasePresenter;
import com.example.cpu11112_local.cleansample.movie.domain.usecase.GetMovieList;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by CPU11112-local on 9/11/2017.
 */

public class ListMoviePresenter extends BasePresenter<ListMovieView> {
    private final GetMovieList mGetMovieList;

    @Inject
    public ListMoviePresenter(@NonNull GetMovieList getMovieList) {
//                              @NonNull ClearCompleteTasks clearCompleteTasks) {
        this.mGetMovieList = getMovieList;
    }


    public void getDataFromServer(String sortBy, int page) {
        mGetMovieList.execute(new MovieListObserver(), new GetMovieList.RequestValues(sortBy, page));
    }

    private final class MovieListObserver extends DisposableObserver<GetMovieList.ResponseValue> {
        @Override
        public void onNext(@io.reactivex.annotations.NonNull GetMovieList.ResponseValue responseValue) {
            getMvpView().setThePullToRefreshDissappear();
            getMvpView().showListMovie(responseValue.getDiscoverMovieResponse());
        }

        @Override
        public void onError(@io.reactivex.annotations.NonNull Throwable e) {
            getMvpView().setThePullToRefreshDissappear();
            e.printStackTrace();
        }

        @Override
        public void onComplete() {

        }
    }
}
