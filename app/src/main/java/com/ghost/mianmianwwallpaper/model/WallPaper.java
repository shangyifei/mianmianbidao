package com.ghost.mianmianwwallpaper.model;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;

/**
 * Created by hello on 2017/3/12.
 */

public class WallPaper {
    private WallpaperManager mWallpaperManager;

    public WallPaper(Context context) {
        mWallpaperManager = WallpaperManager.getInstance(context);
    }
    public void setWapppaper(Bitmap bitmap){
        try {
            mWallpaperManager.setBitmap(bitmap);
        }catch (Exception e){}

    }
}
