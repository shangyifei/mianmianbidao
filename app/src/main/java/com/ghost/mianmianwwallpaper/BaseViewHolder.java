package com.ghost.mianmianwwallpaper;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hello on 2017/3/11.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    View contentView;
    SparseArrayCompat<View> mViewCache;
    public BaseViewHolder(View itemView) {
        super(itemView);
        mViewCache = new SparseArrayCompat<View>();
        this.contentView = itemView;
    }
    public void setText(int id,String text){
        View view = null;
        if ((view = mViewCache.get(id))==null) {
          view = contentView.findViewById(id);
            mViewCache.put(id,view);
        }
        ((TextView)view).setText(text);
    }
    public ImageView getImageView(int id){
        View view = null;
        if ((view = mViewCache.get(id))==null) {
            view = contentView.findViewById(id);
            mViewCache.put(id,view);
        }
        return (ImageView)view;
    }
}
