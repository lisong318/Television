package com.song.programlist;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.widget.FocusHighlight;
import androidx.leanback.widget.FocusHighlightHelper;
import androidx.leanback.widget.VerticalGridView;

import com.song.api.TVShow;

public class TVShowListView extends VerticalGridView {
    private static final String TAG = "TVShowListView";
    private int numCount = 8;

    private TVShowVerticalGridItemBridgeAdapter tvShowVerticalGridItemBridgeAdapter;
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
        tvShowVerticalGridItemBridgeAdapter = new TVShowVerticalGridItemBridgeAdapter(arrayTVShowAdapter);
        setAdapter(tvShowVerticalGridItemBridgeAdapter);
        FocusHighlightHelper.setupBrowseItemFocusHighlight(tvShowVerticalGridItemBridgeAdapter, FocusHighlight.ZOOM_FACTOR_LARGE, false);
        tvShowVerticalGridItemBridgeAdapter.setTvShowVerticalGridItemBridgeAdapterListener(new TVShowVerticalGridItemBridgeAdapter.TVShowVerticalGridItemBridgeAdapterListener() {
            @Override
            public boolean OnClick(int position) {
                if (tvShowListViewListener != null) {
                    TVShow tvShow = (TVShow) arrayTVShowAdapter.get(position);
                    if (!tvShowListViewListener.preparePlay(tvShow)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
        });
    }

    public ArrayTVShowAdapter getArrayTVShowAdapter() {
        return arrayTVShowAdapter;
    }

    public interface TVShowListViewListener {
        boolean preparePlay(TVShow tvShow);
    }

    public void setTvShowListViewListener(TVShowListViewListener tvShowListViewListener) {
        this.tvShowListViewListener = tvShowListViewListener;
    }
}