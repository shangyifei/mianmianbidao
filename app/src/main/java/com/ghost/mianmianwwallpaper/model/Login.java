package com.ghost.mianmianwwallpaper.model;

import com.ghost.mianmianwwallpaper.ResponseEntity;
import com.ghost.mianmianwwallpaper.api.LoginApi;
import com.ghost.mianmianwwallpaper.commen.GsonUtils;
import com.ghost.mianmianwwallpaper.interfaces.ResponseCallback;
import com.ghost.mianmianwwallpaper.entity.UserInfo;
import com.ghost.mianmianwwallpaper.interfaces.LoginCallback;
import com.google.gson.reflect.TypeToken;

/**
 * Created by Ghost on 2017/3/9.
 */

public class Login {
    LoginCallback loginCallback;

    public void login(String username, String pwd){
        LoginApi.getLoginService(username, pwd, new ResponseCallback<String>() {
            @Override
            public void onSuccess(String entity) {
                ResponseEntity<UserInfo> userInfoResponseEntity = GsonUtils.gsonParase(entity,new TypeToken<ResponseEntity<UserInfo>>(){}.getType());
                if (userInfoResponseEntity.isDone()){
                    loginCallback.onSuccess(userInfoResponseEntity.getRetval());
                }else {
                    loginCallback.onFail(userInfoResponseEntity.getMsg());
                }
            }

            @Override
            public void onFail(int error) {

            }
        });
    }

    public void setLoginCallback(LoginCallback loginCallback) {
        this.loginCallback = loginCallback;
    }
}
