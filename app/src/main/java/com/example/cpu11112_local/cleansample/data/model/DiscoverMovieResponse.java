package com.example.cpu11112_local.cleansample.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;


/**
 * Created by CPU11112-local on 9/11/2017.
 */
@Getter
@Entity
public class DiscoverMovieResponse {
    @PrimaryKey(autoGenerate = true)
    public long id;

    // need this column to query
    public String sortBy;

    @SerializedName("page")
    public int page;

    // dont save list of object here
    @SerializedName("results")
    @Ignore
    public List<DiscoverMovie> results;

    @SerializedName("total_pages")
    public int totalPages;

    @SerializedName("total_results")
    public long totalResults;
}
