package com.example.cpu11112_local.cleansample.movie;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cpu11112_local.cleansample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListMovieFragment extends Fragment {
    public ListMovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_movie, container, false);
    }

    public static ListMovieFragment newInstance() {
        return new ListMovieFragment();
    }
}
