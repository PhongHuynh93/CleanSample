package com.example.cpu11112_local.cleansample.utils;

/**
 * Created by CPU11112-local on 9/11/2017.
 */

public class Constant {
    public static final int CONNECT_TIMEOUT = 15;
    public static final int WRITE_TIMEOUT = 60;
    public static final int TIMEOUT = 60;
    public static final String CACHE_DIR = "HttpResponseCache";
    public static final long CACHE_SIZE = 10 * 1024 * 1024;    // 10 MB

    public static final String THE_MOVIE_DB_API_KEY = "53470b56a60668274e1dd9f84d882564";
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    public static final String SITE_YOUTUBE = "YouTube";

    public static final String POSTER_IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
    public static final String POSTER_IMAGE_SIZE = "w780";
    public static final String MOVIE_REPOSITION = "MOVIE_REPOSITION";
    public static final String MOVIE_LOCAL = "MOVIE_LOCAL";
    public static final String MOVIE_REMOTE = "MOVIE_REMOTE";

    // sort type
    public static final String MOST_POPULAR = "popularity.desc";
    public static final String HIGHEST_RATED = "vote_average.desc";
    public static final String MOST_RATED = "vote_count.desc";
}
