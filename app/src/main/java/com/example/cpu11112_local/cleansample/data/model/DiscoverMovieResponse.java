package com.example.cpu11112_local.cleansample.data.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by CPU11112-local on 9/11/2017.
 */
@Getter
public class DiscoverMovieResponse {
    @SerializedName("page")
    int page;

    @SerializedName("results")
    ArrayList<DiscoverMovie> results;

    @SerializedName("total_pages")
    int totalPages;

    @SerializedName("total_results")
    long totalResults;

    @Parcel
    @Getter
    @Setter
    public static class DiscoverMovie {
        @SerializedName("id")
        long id;

        @SerializedName("original_title")
        String originalTitle;

        @SerializedName("overview")
        String overview;

        @SerializedName("release_date")
        String releaseDate;

        @SerializedName("poster_path")
        String posterPath;

        @SerializedName("popularity")
        double popularity;

        @SerializedName("title")
        String title;

        @SerializedName("vote_average")
        double averageVote;

        @SerializedName("vote_count")
        long voteCount;

        @SerializedName("backdrop_path")
        String backdropPath;
    }
}
