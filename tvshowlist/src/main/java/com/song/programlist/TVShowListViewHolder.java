package com.song.programlist;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TVShowListViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;

    public TVShowListViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.name_TextView);
    }

    public TextView getNameTextView() {
        return nameTextView;
    }
}
