package com.ghost.mianmianwwallpaper.interfaces;

import com.ghost.mianmianwwallpaper.entity.ImageEntity;

import java.util.List;

/**
 * Created by hello on 2017/3/11.
 */

public interface ImageListCallback {
    void haveImageList(List<ImageEntity.DataBean> imageList);
}
