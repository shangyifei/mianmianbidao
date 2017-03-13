package com.ghost.mianmianwwallpaper.interfaces;

import com.ghost.mianmianwwallpaper.entity.HotNewsEntity;

import java.util.List;

/**
 * Created by hello on 2017/3/11.
 */

public interface HotNewsCallBack {
    void haveHotNews(List<HotNewsEntity.ListBean> listBeanList);
}
