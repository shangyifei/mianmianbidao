package com.ghost.mianmianwwallpaper.model;

import com.ghost.mianmianwwallpaper.api.ImageApi;
import com.ghost.mianmianwwallpaper.commen.GsonUtils;
import com.ghost.mianmianwwallpaper.entity.ImageEntity;
import com.ghost.mianmianwwallpaper.interfaces.ImageListCallback;
import com.ghost.mianmianwwallpaper.interfaces.NetWorkErrorCallback;
import com.ghost.mianmianwwallpaper.interfaces.ResponseCallback;

/**
 * Created by hello on 2017/3/11.
 */

public class ImageList {
    private ImageListCallback mImageListCallback;
    private NetWorkErrorCallback netWorkErrorCallback;
    public void getImageList(String page, String tag, String tag2){
        ImageApi.getImageListService(page, tag, tag2, new ResponseCallback<String>() {
            @Override
            public void onSuccess(String entity) {
                ImageEntity imageEntity = GsonUtils.gsonParase(entity, ImageEntity.class);
                if (imageEntity.getData().size()>0){
                    mImageListCallback.haveImageList(imageEntity.getData());
                }
            }

            @Override
            public void onFail(int error) {
                netWorkErrorCallback.onNetQorkError();
            }
        });
    }

    public void setmImageListCallback(ImageListCallback mImageListCallback) {
        this.mImageListCallback = mImageListCallback;
    }

    public void setNetWorkErrorCallback(NetWorkErrorCallback netWorkErrorCallback) {
        this.netWorkErrorCallback = netWorkErrorCallback;
    }
}
