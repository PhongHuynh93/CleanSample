package com.example.cpu11112_local.cleansample.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.cpu11112_local.cleansample.data.model.DiscoverMovie;

import java.util.List;

import io.reactivex.Maybe;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by CPU11112-local on 9/13/2017.
 */

@Dao
public interface DiscoverMovieDao {
    // load all datas by sortBy
//    @Query("SELECT * from DiscoverMovieResponse where sortBy = :sortBy")
//    Flowable<DiscoverMovieResponse> loadAllDiscoverMovie(String sortBy);

    @Query("SELECT * from DiscoverMovieResponse where sortBy = :sortBy")
    Maybe<List<DiscoverMovie>> loadAllDiscoverMovieByType(String sortBy);

    @Insert(onConflict = REPLACE)
    void addDiscoverMovie(List<DiscoverMovie> borrowModel);
}
