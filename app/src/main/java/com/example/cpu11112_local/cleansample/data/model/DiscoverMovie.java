package com.example.cpu11112_local.cleansample.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by CPU11112-local on 9/13/2017.
 */

@Parcel
@Getter
@Setter
@Entity
public class DiscoverMovie {
    @PrimaryKey
    @SerializedName("id")
    public long id;

    public String sortBy;

    @SerializedName("original_title")
    public String originalTitle;

    @SerializedName("overview")
    public String overview;

    @SerializedName("release_date")
    public String releaseDate;

    @SerializedName("poster_path")
    public String posterPath;

    @SerializedName("popularity")
    public double popularity;

    @SerializedName("title")
    public String title;

    @SerializedName("vote_average")
    public double averageVote;

    @SerializedName("vote_count")
    public long voteCount;

    @SerializedName("backdrop_path")
    public String backdropPath;
}