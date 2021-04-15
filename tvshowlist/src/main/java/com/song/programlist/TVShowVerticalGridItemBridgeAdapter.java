package com.song.programlist;

import android.view.View;
import android.view.ViewGroup;

import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.ObjectAdapter;

public class TVShowVerticalGridItemBridgeAdapter extends ItemBridgeAdapter {
    public TVShowVerticalGridItemBridgeAdapter(ObjectAdapter adapter) {
        super(adapter);
    }

    private TVShowVerticalGridItemBridgeAdapterListener tvShowVerticalGridItemBridgeAdapterListener;
    private int playPosition = 0;

    @Override
    protected void onCreate(ViewHolder viewHolder) {
        super.onCreate(viewHolder);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playPosition == viewHolder.getAdapterPosition()) {
                    return;
                }
                if (tvShowVerticalGridItemBridgeAdapterListener != null) {
                    if (!tvShowVerticalGridItemBridgeAdapterListener.OnClick(viewHolder.getAdapterPosition())) {
                        return;
                    }
                }
                int tPlayPosition = playPosition;
                playPosition = viewHolder.getAdapterPosition();
                notifyItemChanged(tPlayPosition);
                notifyItemChanged(playPosition);
            }
        });
    }

    @Override
    protected void onBind(ViewHolder viewHolder) {
        ViewGroup layout = viewHolder.itemView.findViewById(R.id.layout);
        super.onBind(viewHolder);
        int adapterPosition = viewHolder.getAdapterPosition();
        if (playPosition == adapterPosition) {
            layout.setBackground(layout.getResources().getDrawable(R.drawable.item_play));
        } else {
            layout.setBackground(layout.getResources().getDrawable(R.drawable.item));
        }
    }

    public interface TVShowVerticalGridItemBridgeAdapterListener {
        boolean OnClick(int position);
    }

    public void setTvShowVerticalGridItemBridgeAdapterListener(TVShowVerticalGridItemBridgeAdapterListener tvShowVerticalGridItemBridgeAdapterListener) {
        this.tvShowVerticalGridItemBridgeAdapterListener = tvShowVerticalGridItemBridgeAdapterListener;
    }
}