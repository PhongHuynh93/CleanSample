package com.example.cpu11112_local.cleansample.movie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.cpu11112_local.cleansample.R;
import com.example.cpu11112_local.cleansample.utils.ActivityUtils;

public class ListMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add fragment
        MovieViewpagerFragment listMovieFragment = (MovieViewpagerFragment) getSupportFragmentManager().findFragmentById(R.id.framelayout_act_main_content);
        if (listMovieFragment == null) {
            listMovieFragment = MovieViewpagerFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), listMovieFragment, R.id.framelayout_act_main_content);
        }
    }
}
