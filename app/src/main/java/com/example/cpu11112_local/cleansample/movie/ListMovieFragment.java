package com.example.cpu11112_local.cleansample.movie;


import android.support.v4.app.Fragment;
import android.view.View;

import com.example.cpu11112_local.cleansample.R;
import com.example.cpu11112_local.cleansample.view.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListMovieFragment extends BaseFragment {
    public ListMovieFragment() {
        // Required empty public constructor
    }

    public static ListMovieFragment newInstance() {
        return new ListMovieFragment();
    }

    @Override
    public int getResourceLayout() {
        return R.layout.fragment_list_movie;
    }

    @Override
    public void initViews(View view) {
        fragmentComponent().inject(this);
//        mPresenter.attachView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        mPresenter.detachView(this);
    }
}
