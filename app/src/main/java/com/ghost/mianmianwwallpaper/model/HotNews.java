package com.ghost.mianmianwwallpaper.model;

import com.ghost.mianmianwwallpaper.api.HotNesApi;
import com.ghost.mianmianwwallpaper.commen.GsonUtils;
import com.ghost.mianmianwwallpaper.entity.HotNewsEntity;
import com.ghost.mianmianwwallpaper.interfaces.HotNewsCallBack;
import com.ghost.mianmianwwallpaper.interfaces.NetWorkErrorCallback;
import com.ghost.mianmianwwallpaper.interfaces.ResponseCallback;
import com.google.gson.Gson;

/**
 * Created by hello on 2017/3/11.
 */

public class HotNews {
    private HotNewsCallBack mHotNewsCallBack;
    private NetWorkErrorCallback mNetWorkErrorCallback;
    public void getHotNews(String type,String page){
        HotNesApi.getHotNewsService(type, page, new ResponseCallback<String>() {
            @Override
            public void onSuccess(String entity) {
                HotNewsEntity hotNewsEntity = GsonUtils.gsonParase(entity,HotNewsEntity.class);
                if (hotNewsEntity.getList().size()!=0){
                    mHotNewsCallBack.haveHotNews(hotNewsEntity.getList());
                }
            }

            @Override
            public void onFail(int error) {
                mNetWorkErrorCallback.onNetQorkError();
            }
        });
    }

    public void setmHotNewsCallBack(HotNewsCallBack mHotNewsCallBack) {
        this.mHotNewsCallBack = mHotNewsCallBack;
    }

    public void setmNetWorkErrorCallback(NetWorkErrorCallback mNetWorkErrorCallback) {
        this.mNetWorkErrorCallback = mNetWorkErrorCallback;
    }
}
