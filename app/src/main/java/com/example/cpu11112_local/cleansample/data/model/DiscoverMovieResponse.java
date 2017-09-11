package com.example.cpu11112_local.cleansample.data.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by CPU11112-local on 9/11/2017.
 */
@Getter
public class DiscoverMovieResponse {
    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private ArrayList<DiscoverMovie> results;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("total_results")
    private long totalResults;

    @AllArgsConstructor
    @Parcel
    @Getter
    @Setter
    public static class DiscoverMovie {
        @SerializedName("id")
        private long id;

        @SerializedName("original_title")
        private String originalTitle;

        @SerializedName("overview")
        private String overview;

        @SerializedName("release_date")
        private String releaseDate;

        @SerializedName("poster_path")
        private String posterPath;

        @SerializedName("popularity")
        private double popularity;

        @SerializedName("title")
        private String title;

        @SerializedName("vote_average")
        private double averageVote;

        @SerializedName("vote_count")
        private long voteCount;

        @SerializedName("backdrop_path")
        private String backdropPath;
    }
}
