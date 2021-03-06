package com.fedming.gdoulife.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * BaseRecycleViewHolderView
 * Created by fedming on 2016/9/1.
 */

public class BaseRecycleViewHolderView extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    private MyItemClickListener myItemClickListener;
    private MyItemLongClickListener myItemLongClickListener;

    public BaseRecycleViewHolderView(View itemView, MyItemClickListener myItemClickListener) {
        super(itemView);

        this.myItemClickListener = myItemClickListener;
        itemView.setOnClickListener(this);
    }

    public BaseRecycleViewHolderView(View itemView, MyItemClickListener myItemClickListener, MyItemLongClickListener myItemLongClickListener) {
        super(itemView);

        this.myItemClickListener = myItemClickListener;
        this.myItemLongClickListener = myItemLongClickListener;

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (myItemClickListener != null) {
            myItemClickListener.onItemClick(v, getPosition());
        }
    }

    @Override
    public boolean onLongClick(View v) {

        if (myItemLongClickListener != null) {
            myItemLongClickListener.onItemLongClick(v, getPosition());
        }
        return true;
    }

    public interface MyItemClickListener {
        public void onItemClick(View view, int position);
    }

    public interface MyItemLongClickListener {
        public void onItemLongClick(View view, int position);
    }
}
