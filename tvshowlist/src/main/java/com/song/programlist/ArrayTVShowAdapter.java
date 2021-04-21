package com.song.programlist;

import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.Presenter;

import com.song.api.TVShow;

public class ArrayTVShowAdapter extends ArrayObjectAdapter {
    public ArrayTVShowAdapter(Presenter presenter) {
        super(presenter);
    }

    public void add(TVShow tvShow) {
        super.add(tvShow);
    }
}