package com.example.cpu11112_local.cleansample.movie.domain.usecase;

import com.example.cpu11112_local.cleansample.UseCase;
import com.example.cpu11112_local.cleansample.data.model.DiscoverMovieResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by CPU11112-local on 9/11/2017.
 */

public class GetMovieList extends UseCase<DiscoverMovieResponse, Void>{
    // TODO: 9/11/2017 insert reposition here
    @Inject
    public GetMovieList() {
        super();
//        this.userRepository = userRepository;
    }

    @Override
    public Observable<DiscoverMovieResponse> buildUseCaseObservable(Void aVoid) {
        return null;
    }
}
