package com.example.cpu11112_local.cleansample.data.remote;

import com.example.cpu11112_local.cleansample.data.model.DiscoverMovieResponse;
import com.example.cpu11112_local.cleansample.data.model.MovieReviewsResponse;
import com.example.cpu11112_local.cleansample.data.model.MovieVideosResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by CPU11112-local on 9/11/2017.
 */
public interface MovieRetrofitEndpoint {
    @GET("movie/{id}/videos")
    Observable<MovieVideosResponse> getMovieVideos(@Path("id") long movieId);

    @GET("movie/{id}/reviews")
    Observable<MovieReviewsResponse> getMovieReviews(@Path("id") long movieId);

    @GET("discover/movie")
    Observable<DiscoverMovieResponse> discoverMovies(@Query("sort_by") String sortBy, @Query("page") int page);
}
