package com.song.programlist;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.song.api.TVShowManager;

public class TVShowListView extends RecyclerView {
    private static final String TAG = TVShowListView.class.getSimpleName();
    private int spanCount = 8;
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
        init(context);
    }

    /**
     * 初始化
     */
    int margin = 30;
    private void init(Context context) {
        tvShowListGridLayoutManager = new TVShowListGridLayoutManager(context, spanCount);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL);
        tvShowManager = new TVShowManager();
        tvShowListAdapter = new TVShowListAdapter(tvShowManager);
        setLayoutManager(tvShowListGridLayoutManager);
        setAdapter(tvShowListAdapter);

        ItemDecoration itemDecoration = new ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull State state) {

                if (parent.getChildAdapterPosition(view) %spanCount == 0) {
                    outRect.left = 0; //第一列左边贴边
                } else {
                    if (parent.getChildAdapterPosition(view) %spanCount == 1) {
                        outRect.left = margin;//第二列移动一个位移间距
                    } else {
                        outRect.left = margin * 2;//由于第二列已经移动了一个间距，所以第三列要移动两个位移间距就能右边贴边，且item间距相等
                    }
                }
            }
        };
        addItemDecoration(itemDecoration);
    }

    public TVShowManager getTvShowManager() {
        return tvShowManager;
    }
}