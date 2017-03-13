package com.ghost.mianmianwwallpaper.model;

import android.content.Context;

import com.ghost.mianmianwwallpaper.BaseRecyclerViewAdapter;
import com.ghost.mianmianwwallpaper.BaseViewHolder;
import com.ghost.mianmianwwallpaper.commen.ImageLoader;
import com.ghost.mianmianwwallpaper.entity.ImageEntity;

import java.util.List;
import com.ghost.mianmianwwallpaper.R;
/**
 * Created by hello on 2017/3/11.
 */

public class ImageListAdapter extends BaseRecyclerViewAdapter<ImageEntity.DataBean> {
    public ImageListAdapter(List mEntitys, int mResId, Context mContext) {
        super(mEntitys, mResId, mContext);
    }

    protected void convert(BaseViewHolder holder, ImageEntity.DataBean entity) {
        ImageLoader.getInstance().displayImage(entity.getImage_url(),holder.getImageView(R.id.iv_image));
    }
}
