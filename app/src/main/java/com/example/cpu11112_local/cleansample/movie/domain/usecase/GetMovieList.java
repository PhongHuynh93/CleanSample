package com.example.cpu11112_local.cleansample.movie.domain.usecase;

import android.support.annotation.NonNull;

import com.example.cpu11112_local.cleansample.UseCase;
import com.example.cpu11112_local.cleansample.data.MovieDataSource;
import com.example.cpu11112_local.cleansample.data.model.DiscoverMovieResponse;
import com.example.cpu11112_local.cleansample.utils.Constant;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import lombok.Getter;

/**
 * Created by CPU11112-local on 9/11/2017.
 */
public class GetMovieList extends UseCase<GetMovieList.RequestValues, GetMovieList.ResponseValue>{
    private final MovieDataSource movieReposition;

    // TODO: 9/11/2017 insert reposition here
    @Inject
    public GetMovieList(@Named(Constant.MOVIE_REPOSITION) MovieDataSource movieReposition) {
        super();
        this.movieReposition = movieReposition;
    }


    @Override
    protected Observable<ResponseValue> buildUseCaseObservable(RequestValues requestValues) {
        return movieReposition.getRemoteDatas(requestValues.getSortBy(), requestValues.getPage())
                .map(ResponseValue::new);
    }

    @Getter
    public static final class RequestValues implements UseCase.RequestValues {
        private final String sortBy;
        private final int page;

        public RequestValues(String sortBy, int page) {
            this.sortBy = sortBy;
            this.page = page;
        }
    }

    @Getter
    public static final class ResponseValue implements UseCase.ResponseValue {
        private final DiscoverMovieResponse discoverMovieResponse;

        public ResponseValue(@NonNull DiscoverMovieResponse discoverMovieResponse) {
            this.discoverMovieResponse = discoverMovieResponse;
        }
    }
}
