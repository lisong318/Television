package com.song.programlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.leanback.widget.Presenter;

import com.song.api.TVShow;

public class TVShowPresenter extends Presenter {
    private static final String TAG = "TVShowPresenter";

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.tvshow_item, parent, false);
        TVShowViewHolder tvShowViewHolder = new TVShowViewHolder(inflate);
        return tvShowViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        TVShowViewHolder tvShowViewHolder = (TVShowViewHolder) viewHolder;
        TVShow tvShow = (TVShow) item;
        tvShowViewHolder.getNameTextView().setText(tvShow.getName());
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }
}
