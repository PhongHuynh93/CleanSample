package com.example.cpu11112_local.cleansample.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by CPU11112-local on 9/11/2017.
 */
@Getter
@Entity
public class DiscoverMovieResponse {
//    @PrimaryKey(autoGenerate = true)
//    long id;

    // need this column to query
    String sortBy;

    @PrimaryKey
    @SerializedName("page")
    int page;

    @SerializedName("results")
    @Ignore
    List<DiscoverMovie> results;

    @SerializedName("total_pages")
    int totalPages;

    @SerializedName("total_results")
    long totalResults;

    @Parcel
    @Getter
    @Setter
    @Entity(foreignKeys = {
            @ForeignKey(
                    entity = DiscoverMovieResponse.class,
                    parentColumns = "sortBy",
                    childColumns = "sortBy"
            )})
    public static class DiscoverMovie {
        @PrimaryKey
        @SerializedName("id")
        long id;

        String sortBy;

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
