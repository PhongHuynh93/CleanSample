package com.example.cpu11112_local.cleansample.movie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cpu11112_local.cleansample.R;
import com.example.cpu11112_local.cleansample.data.model.DiscoverMovie;
import com.example.cpu11112_local.cleansample.utils.Constant;
import com.example.cpu11112_local.cleansample.utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by huynhducthanhphong on 8/1/16.
 */
public class ListMovieRecyclerViewAdapter extends RecyclerView.Adapter<ListMovieRecyclerViewAdapter.MovieViewHolder> {
    private final Context mContext;
    private OnItemClickListener onItemClickListener;
    private List<DiscoverMovie> mListData;

    public ListMovieRecyclerViewAdapter(Context context) {
        this.mContext = context;
        mListData = new ArrayList<>();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contactView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        return new MovieViewHolder(contactView, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder viewHolder, int position) {
        DiscoverMovie movie = mListData.get(position);
        viewHolder.mTextviewListmovieNameofmovie.setText(movie.getOriginalTitle());
        viewHolder.mfabVoteAverate.setText("" + movie.getAverageVote());
        viewHolder.mTextViewListMovieViewCount.setText("" + movie.getVoteCount());
        viewHolder.mTextviewListmovieDescriptionofmovie.setText(movie.getOverview());

        String urlImage = Constant.POSTER_IMAGE_BASE_URL + Constant.POSTER_IMAGE_SIZE + movie.getPosterPath();

        /**
         * diskCacheStrategy.ALL cache full size of image and then resize it.
         * Use for resize image for detail list movie activity.
         */
        Glide.with(mContext)
                .load(urlImage)
                .into(viewHolder.mImageviewListmovieImageofmovie);
    }

    // TODO: 9/12/2017 if page = 1, remove all data.
    public void setData(List<DiscoverMovie> listData) {
        mListData.addAll(listData);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public DiscoverMovie getItem(int position) {
        return mListData.get(position);
    }

    public void resetData() {
        mListData.clear();
        notifyDataSetChanged();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private OnItemClickListener onItemClickListener;
        @BindView(R.id.textview_listmovie_nameofmovie)
        TextView mTextviewListmovieNameofmovie;
        @BindView(R.id.textview_listmovie_typeofmovie)
        TextView mTextviewListmovieTypeofmovie;
        @BindView(R.id.textview_listmovie_lengthofmovie)
        TextView mTextviewListmovieLengthofmovie;
        @BindView(R.id.textview_listmovie_descriptionofmovie)
        TextView mTextviewListmovieDescriptionofmovie;
        @BindView(R.id.imageview_listmovie_imageofmovie)
        ImageView mImageviewListmovieImageofmovie;
        @BindView(R.id.textview_listmovie_vote)
        TextView mfabVoteAverate;
        @BindView(R.id.textview_listmovie_viewcount)
        TextView mTextViewListMovieViewCount;


        public MovieViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
}
