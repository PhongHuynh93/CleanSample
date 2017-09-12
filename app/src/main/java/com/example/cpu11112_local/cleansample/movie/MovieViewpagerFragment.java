package com.example.cpu11112_local.cleansample.movie;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.cpu11112_local.cleansample.R;
import com.example.cpu11112_local.cleansample.view.BaseFragment;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieViewpagerFragment extends BaseFragment {

    @BindView(R.id.viewpager_frag_list_movie_contain)
    ViewPager mViewpagerFragListMovieContent;
    @BindView(R.id.tablayout_fraglistmovie)
    TabLayout mTablayoutFraglistmovie;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    
    public MovieViewpagerFragment() {
        // Required empty public constructor
    }

    public static MovieViewpagerFragment newInstance() {
        return new MovieViewpagerFragment();
    }

    @Override
    public int getResourceLayout() {
        return R.layout.fragment_list_movie;
    }

    @Override
    public void initViews(View view) {
    }
}
