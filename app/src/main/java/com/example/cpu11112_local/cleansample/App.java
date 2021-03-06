package com.example.cpu11112_local.cleansample;

import android.app.Application;
import android.content.Context;

import com.example.cpu11112_local.cleansample.injection.component.DaggerMovieComponent;
import com.example.cpu11112_local.cleansample.injection.component.MovieComponent;
import com.example.cpu11112_local.cleansample.injection.module.ApplicationModule;
import com.example.cpu11112_local.cleansample.injection.module.MovieApiServiceModule;
import com.example.cpu11112_local.cleansample.injection.module.RepositionModule;
import com.facebook.stetho.Stetho;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by CPU11112-local on 9/11/2017.
 */

public class App extends Application {
    private MovieComponent mMovieComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);

        mMovieComponent = DaggerMovieComponent
                .builder()
                .applicationModule(new ApplicationModule((getApplicationContext())))
                .repositionModule(new RepositionModule())
                .movieApiServiceModule(new MovieApiServiceModule())
                .build();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Helvetica.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public MovieComponent getComponent() {
        return mMovieComponent;
    }
}
