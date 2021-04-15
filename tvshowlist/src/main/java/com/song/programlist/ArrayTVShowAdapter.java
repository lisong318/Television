package com.song.programlist;

import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.Presenter;

import com.song.api.TVShow;

import java.util.List;

public class ArrayTVShowAdapter extends ArrayObjectAdapter {
    public ArrayTVShowAdapter(Presenter presenter) {
        super(presenter);
    }

    public void add(TVShow tvShow) {
        super.add(tvShow);
    }

    public void add(int index, TVShow tvShow) {
        super.add(index, tvShow);
    }

    public void addAll(List<TVShow> tvShowList) {
        for (TVShow tvShow : tvShowList) {
            add(tvShow);
        }
    }
}