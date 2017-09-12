package com.example.cpu11112_local.cleansample.movie;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.toolbar_open_drawer);
            ab.setDisplayHomeAsUpEnabled(true); // set the left arrow in toolbar
            ab.setTitle("MOVIES");
        }
        // TODO: 9/12/2017 add the adapter into this viewpager
        // set up viewpager
        mViewpagerFragListMovieContent.setAdapter(new ListMovieViewPagerAdapter(getContext(), getChildFragmentManager()));
        mTablayoutFraglistmovie.setupWithViewPager(mViewpagerFragListMovieContent);
    }
}
