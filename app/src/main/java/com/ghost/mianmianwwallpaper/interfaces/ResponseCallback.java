package com.ghost.mianmianwwallpaper.interfaces;

/**
 * Created by Ghost on 2017/3/9.
 */

public interface ResponseCallback<T> {
    void onSuccess(T entity);
    void onFail(int error);
}
