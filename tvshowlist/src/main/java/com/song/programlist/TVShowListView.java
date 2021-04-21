package com.song.programlist;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.widget.FocusHighlight;
import androidx.leanback.widget.FocusHighlightHelper;
import androidx.leanback.widget.VerticalGridView;

import com.song.api.TVShow;

import java.util.ArrayList;

public class TVShowListView extends VerticalGridView {
    private static final String TAG = "TVShowListView";
    private int numCount = 8;

    private TVShowItemBridgeAdapter tvShowItemBridgeAdapter;
    private ArrayTVShowAdapter arrayTVShowAdapter;
    private TVShowListViewListener tvShowListViewListener;

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
        setNumColumns(numCount);
        TVShowPresenter tvShowPresenter = new TVShowPresenter();
        arrayTVShowAdapter = new ArrayTVShowAdapter(tvShowPresenter);
        tvShowItemBridgeAdapter = new TVShowItemBridgeAdapter(arrayTVShowAdapter);
        setAdapter(tvShowItemBridgeAdapter);
        FocusHighlightHelper.setupBrowseItemFocusHighlight(tvShowItemBridgeAdapter, FocusHighlight.ZOOM_FACTOR_LARGE, false);
        tvShowItemBridgeAdapter.setTvShowItemBridgeAdapterListener(new TVShowItemBridgeAdapter.TVShowItemBridgeAdapterListener() {
            @Override
            public boolean onClick(int position) {
                if (tvShowListViewListener != null) {
                    TVShow tvShow = (TVShow) arrayTVShowAdapter.get(position);
                    if (!tvShowListViewListener.onClickByItem(tvShow)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
        });
    }

    public interface TVShowListViewListener {
        boolean onClickByItem(TVShow tvShow);
    }

    public void setTvShowListViewListener(TVShowListViewListener tvShowListViewListener) {
        this.tvShowListViewListener = tvShowListViewListener;
    }

    public void add(TVShow tvShow) {
        arrayTVShowAdapter.add(tvShow);
    }
    public void addAll(ArrayList<TVShow> tvShowArrayList){
        for (TVShow tvShow : tvShowArrayList) {
            add(tvShow);
        }
    }
}