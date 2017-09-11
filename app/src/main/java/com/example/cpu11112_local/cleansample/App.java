package com.example.cpu11112_local.cleansample;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by CPU11112-local on 9/11/2017.
 */

public class App extends Application {
    private MovieComponent mMovieComponent;

    @Override
    public void onCreate() {
        super.onCreate();
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
}
