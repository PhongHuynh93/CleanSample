package com.example.cpu11112_local.cleansample.movie;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.cpu11112_local.cleansample.R;
import com.example.cpu11112_local.cleansample.utils.Constant;
import com.example.cpu11112_local.cleansample.utils.SmartFragmentStatePagerAdapter;

/**
 * Created by huynhducthanhphong on 7/28/16.
 * FragmentStatePagerAdapter: can destroy view which have not seen, so every time a page changes, load data again
 */
public class ListMovieViewPagerAdapter extends SmartFragmentStatePagerAdapter {
    private static final int NUM_ITEMS = 3;
    public static final int MOST_POPULAR = 0;
    public static final int HIGHEST_RATED = 1;
    public static final int MOST_RATED = 2;
    private final Context mContext;

    public ListMovieViewPagerAdapter(Context context, FragmentManager fm) {
        super(context, fm);
        mContext = context;
    }

    /**
     * getItem will be called whenever the adapter needs a fragment and the fragment does not exist.
     * -> khi đã tạo rồi thì ko có gọi nữa
     * in this method: create three view with three presenter
     * @param position
     * @return
     * http://stackoverflow.com/questions/19339500/when-is-fragmentpageradapters-getitem-called
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case MOST_POPULAR: // ListMovieItemFragment # 0 - This will show FirstFragment
                return ListMovieFragment.newInstance(Constant.MOST_POPULAR);
            case HIGHEST_RATED: // ListMovieItemFragment # 0 - This will show FirstFragment different title
                return ListMovieFragment.newInstance(Constant.HIGHEST_RATED);
            case MOST_RATED: // ListMovieItemFragment # 1 - This will show SecondFragment
                return ListMovieFragment.newInstance(Constant.MOST_RATED);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case MOST_POPULAR:
                return mContext.getResources().getString(R.string.home_adapter_pager_most_popular);
            case HIGHEST_RATED:
                return mContext.getResources().getString(R.string.home_adapter_pager_highest_rated);
            case MOST_RATED:
                return mContext.getResources().getString(R.string.home_adapter_pager_most_rated);
            default:
                return null;
        }
    }
}
