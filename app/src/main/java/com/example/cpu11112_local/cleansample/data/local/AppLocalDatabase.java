package com.example.cpu11112_local.cleansample.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.cpu11112_local.cleansample.data.model.DiscoverMovieResponse;

/**
 * Created by CPU11112-local on 9/13/2017.
 */
@Database(entities = {DiscoverMovieResponse.DiscoverMovie.class}, version = 1)
public abstract class AppLocalDatabase extends RoomDatabase {

    public abstract DiscoverMovieDao userDao();

    public static AppLocalDatabase getAppDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), AppLocalDatabase.class, "movie-database")
                .build();
    }
}
