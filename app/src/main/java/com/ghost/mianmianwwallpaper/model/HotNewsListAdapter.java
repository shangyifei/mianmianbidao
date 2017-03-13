package com.ghost.mianmianwwallpaper.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.ghost.mianmianwwallpaper.BaseRecyclerViewAdapter;
import com.ghost.mianmianwwallpaper.BaseViewHolder;
import com.ghost.mianmianwwallpaper.commen.ImageLoader;
import com.ghost.mianmianwwallpaper.entity.HotNewsEntity;
import com.ghost.mianmianwwallpaper.R;
import java.util.List;

/**
 * Created by hello on 2017/3/11.
 */

public class HotNewsListAdapter extends BaseRecyclerViewAdapter<HotNewsEntity.ListBean> {
    public HotNewsListAdapter(List mEntitys, int mResId, Context mContext) {
        super(mEntitys, mResId, mContext);
    }

    @Override
    protected void convert(BaseViewHolder holder, HotNewsEntity.ListBean entity) {
        holder.setText(R.id.tv_news_title,entity.getTitle());
        holder.setText(R.id.tv_time,entity.getTime());
        ImageLoader.getInstance().displayImage(entity.getImgurl(),holder.getImageView(R.id.iv_news_image));
    }

}
