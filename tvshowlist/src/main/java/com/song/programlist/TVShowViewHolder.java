package com.song.programlist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.leanback.widget.Presenter;

public class TVShowViewHolder  extends Presenter.ViewHolder {
    private TextView nameTextView;
    private ViewGroup layout;
    public TVShowViewHolder(View view) {
        super(view);
        nameTextView = view.findViewById(R.id.name_TextView);
        layout = view.findViewById(R.id.layout);
    }

    public TextView getNameTextView() {
        return nameTextView;
    }

    public ViewGroup getLayout() {
        return layout;
    }
}
