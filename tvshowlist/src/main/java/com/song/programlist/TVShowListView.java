package com.song.programlist;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.song.api.TVShowManager;

public class TVShowListView extends RecyclerView {
    private int spanCount = 6;
    private TVShowListGridLayoutManager tvShowListGridLayoutManager;
    private TVShowListAdapter tvShowListAdapter;
    private TVShowManager tvShowManager;

    public TVShowListView(@NonNull Context context) {
        this(context, null);
    }

    public TVShowListView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TVShowListView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        tvShowListGridLayoutManager = new TVShowListGridLayoutManager(getContext(), spanCount);
        tvShowManager = new TVShowManager();
        tvShowListAdapter = new TVShowListAdapter(tvShowManager);
        setLayoutManager(tvShowListGridLayoutManager);
        setAdapter(tvShowListAdapter);
    }

    public TVShowManager getTvShowManager() {
        return tvShowManager;
    }
}