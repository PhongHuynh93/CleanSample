package com.example.cpu11112_local.cleansample.data.model;

/**
 * Created by huynhducthanhphong on 7/30/16.
 */

import com.example.cpu11112_local.cleansample.utils.Constant;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.Locale;

import lombok.Getter;

@Getter
public class MovieVideosResponse {
    @SerializedName("id")
    private long movieId;

    @SerializedName("results")
    private ArrayList<MovieVideo> results;

    @Parcel
    @Getter
    public static class MovieVideo{
        @SerializedName("id")
        private String videoId;

        @SerializedName("iso_639_1")
        private String languageCode;

        @SerializedName("iso_3166_1")
        private String countryCode;

        // declare the key to go to exactly where the video will be played
        @SerializedName("key")
        private String key;

        @SerializedName("name")
        private String name;

        // declare which site contains this video clip
        @SerializedName("site")
        private String site;

        @SerializedName("size")
        private int size;

        @SerializedName("type")
        private String type;

        // find out the site of movies whether it if from youtube or not.
        public boolean isYoutubeVideo() {
            return site.toLowerCase(Locale.US).equals(Constant.SITE_YOUTUBE.toLowerCase(Locale.US));
        }
    }
}
