package com.ghost.mianmianwwallpaper.interfaces;

import com.ghost.mianmianwwallpaper.entity.UserInfo;

/**
 * Created by Ghost on 2017/3/9.
 */

public interface LoginCallback {
    void onFail(String msg);
    void onSuccess(UserInfo userInfo);
}
