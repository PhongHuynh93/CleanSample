package com.example.cpu11112_local.cleansample.movie.domain.usecase;

import com.example.cpu11112_local.cleansample.UseCase;
import com.example.cpu11112_local.cleansample.data.MovieDataSource;
import com.example.cpu11112_local.cleansample.data.model.DiscoverMovieResponse;
import com.example.cpu11112_local.cleansample.utils.Constant;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;

/**
 * Created by CPU11112-local on 9/11/2017.
 */
public class GetMovieList extends UseCase<DiscoverMovieResponse, Integer>{
    private final MovieDataSource movieReposition;

    // TODO: 9/11/2017 insert reposition here
    @Inject
    public GetMovieList(@Named(Constant.MOVIE_REPOSITION) MovieDataSource movieReposition) {
        super();
        this.movieReposition = movieReposition;
    }

    @Override
    public Observable<DiscoverMovieResponse> buildUseCaseObservable(Integer page) {
        return movieReposition.getRemoteDatas(page);
    }
}
