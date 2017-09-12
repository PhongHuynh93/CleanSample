package com.example.cpu11112_local.cleansample.movie;

import android.support.annotation.NonNull;

import com.example.cpu11112_local.cleansample.R;


/**
 * Created by phongdth.ky on 8/11/2016.
 */
public class ListMovieFragment extends BaseListMovieFragment {

    public ListMovieFragment() {
    }

    @NonNull
    public static ListMovieFragment newInstance() {
        return new ListMovieFragment();
    }

    /**
     * a child fragment can use to make their own layout, set force load sepend on sort of viewpager
     */
    @Override
    protected void loadData(int page) {
        // TODO: 9/12/2017 get from the remote site
        getDataFromServer(page);
//        getMListener().setForceLoad();
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
