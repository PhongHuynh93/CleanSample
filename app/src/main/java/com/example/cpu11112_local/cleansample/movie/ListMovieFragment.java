package com.example.cpu11112_local.cleansample.movie;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.cpu11112_local.cleansample.R;
import com.example.cpu11112_local.cleansample.data.model.DiscoverMovieResponse;


/**
 * Created by phongdth.ky on 8/11/2016.
 */
public class ListMovieFragment extends BaseListMovieFragment {
    private static final String ARG_SORT_KEY = "ARG_SORT_KEY";

    public ListMovieFragment() {
    }

    @NonNull
    public static ListMovieFragment newInstance(String sortBy) {
        ListMovieFragment fragment = new ListMovieFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_SORT_KEY, sortBy);
        fragment.setArguments(bundle);
        return fragment;
    }

    /**
     * a child fragment can use to make their own layout, set force load sepend on sort of viewpager
     */
    @Override
    protected void loadData(int page) {
        // TODO: 9/12/2017 get from the remote site
        getDataFromServer(page, getArguments().getString(ARG_SORT_KEY));
    }

    @Override
    public void setThePullToRefreshAppear() {
        getMSwiperefreshHome().setRefreshing(true);
    }

    @Override
    public int getResourceLayout() {
        return R.layout.fragment_item_list_movie;
    }
}
