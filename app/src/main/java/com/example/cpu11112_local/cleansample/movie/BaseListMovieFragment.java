package com.example.cpu11112_local.cleansample.movie;


import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.cpu11112_local.cleansample.R;
import com.example.cpu11112_local.cleansample.data.model.DiscoverMovieResponse;
import com.example.cpu11112_local.cleansample.utils.EndlessRecyclerViewScrollListener;
import com.example.cpu11112_local.cleansample.utils.HelpUtils;
import com.example.cpu11112_local.cleansample.utils.VerticalSpaceItemDecoration;
import com.example.cpu11112_local.cleansample.view.BaseFragment;

import butterknife.BindView;
import lombok.Getter;

/**
 * A simple {@link Fragment} subclass.
 * a base fragment which show a list of movie,
 * by connecting to server and load data to adapter
 *
 * 2 child frag implement this
 *
 */
// : 8/9/2016 set the adapter in dagger
public abstract class BaseListMovieFragment extends BaseFragment {
    ListMovieRecyclerViewAdapter mListMovieRecyclerViewAdapter;

    @BindView(R.id.recyclerview_home_list_movies)
    RecyclerView mRecyclerviewHomeListMovies;

    @Getter
    @BindView(R.id.swiperefresh_home)
    SwipeRefreshLayout mSwiperefreshHome;

    private EndlessRecyclerViewScrollListener endlessRecyclerViewScrollListener;

    @Getter
    private OnFragInteract mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            mListener = (OnFragInteract) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void initViews(View view) {
        // Configure the refreshing colors
        mSwiperefreshHome.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mSwiperefreshHome.setOnRefreshListener(() -> loadData(1));

        mListMovieRecyclerViewAdapter = new ListMovieRecyclerViewAdapter(getContext());
        // : 8/1/16 set adapter for recyclerview
        mListMovieRecyclerViewAdapter.setOnItemClickListener((itemView, position) -> {
            // =: 8/7/16 when click, go to another activity to show detail
            mListener.gotoDetailActivity(mListMovieRecyclerViewAdapter.getItem(position));
        });
        mRecyclerviewHomeListMovies.setAdapter(mListMovieRecyclerViewAdapter);
        // make list show 1 vertical column of data
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerviewHomeListMovies.setLayoutManager(linearLayoutManager);
        // add space between list
        mRecyclerviewHomeListMovies.addItemDecoration(new VerticalSpaceItemDecoration((int) HelpUtils.getPixelForDp(getContext(), 13)));
        mRecyclerviewHomeListMovies.setHasFixedSize(true);

        endlessRecyclerViewScrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            // : 8/1/16 load more items from list
            public void onLoadMore(int page, int totalItemsCount) {
                setThePullToRefreshAppear();
                loadData(page);
            }
        };
        mRecyclerviewHomeListMovies.addOnScrollListener(endlessRecyclerViewScrollListener);
    }

    protected abstract void loadData(int page);

    public abstract void setThePullToRefreshAppear();

    public void setThePullToRefreshDissappear() {
        mSwiperefreshHome.setRefreshing(false);
    }

    // turn off loading for new news
    public void stopEndlessListener() {
        endlessRecyclerViewScrollListener.setLoading(false);
    }

    public void updateLayout() {
        if (mListMovieRecyclerViewAdapter.getItemCount() == 0) {
            mRecyclerviewHomeListMovies.setVisibility(View.GONE);
//            noMoviesView.setVisibility(View.VISIBLE);
        } else {
            mRecyclerviewHomeListMovies.setVisibility(View.VISIBLE);
//            noMoviesView.setVisibility(View.GONE);
        }
    }

    public interface OnFragInteract {
        void gotoDetailActivity(DiscoverMovieResponse.DiscoverMovie item);
    }
}
