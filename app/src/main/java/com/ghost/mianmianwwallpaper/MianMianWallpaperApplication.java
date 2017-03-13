package com.ghost.mianmianwwallpaper;

import android.app.Application;

/**
 * Created by Ghost on 2017/3/13.
 */

public class MianMianWallpaperApplication extends Application {
    static MianMianWallpaperApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MianMianWallpaperApplication getInstance(){
        return instance;
    }
}
