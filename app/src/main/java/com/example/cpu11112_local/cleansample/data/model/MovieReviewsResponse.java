package com.example.cpu11112_local.cleansample.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.Getter;

@Getter
public class MovieReviewsResponse {
    @SerializedName("id")
    private long movieId;

    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private ArrayList<MovieReview> results;

    @SerializedName("total_pages")
    private int totalPages;

    @Getter
    public static class MovieReview {
        @SerializedName("id")
        private String reviewId;

        @SerializedName("author")
        private String author;

        @SerializedName("url")
        private String reviewUrl;

        @SerializedName("content")
        private String content;

    }
}
