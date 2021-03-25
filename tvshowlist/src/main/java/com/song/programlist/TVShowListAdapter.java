package com.song.programlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.song.api.TVShowManager;

public class TVShowListAdapter extends RecyclerView.Adapter<TVShowListViewHolder> {
    private TVShowManager tvShowManager;

    public TVShowListAdapter(TVShowManager tvShowManager) {
        setTvShowManager(tvShowManager);
    }

    @NonNull
    @Override
    public TVShowListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //待完成
        View itemView = LayoutInflater.from(parent.getContext()).inflate(0, parent, false);
        return new TVShowListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TVShowListViewHolder holder, int position) {
        View itemView = holder.itemView;
        TextView nameTextView = holder.getNameTextView();
        nameTextView.setText(getTvShowManager().getTvShowArrayList().get(position).getName());
        //待完成
        itemView.setOnClickListener(null);
        //待完成
        itemView.setOnFocusChangeListener(null);
    }

    @Override
    public int getItemCount() {
        return getTvShowManager().getTvShowArrayList().size();
    }

    public TVShowManager getTvShowManager() {
        return tvShowManager;
    }

    public void setTvShowManager(TVShowManager tvShowManager) {
        this.tvShowManager = tvShowManager;
    }
}
