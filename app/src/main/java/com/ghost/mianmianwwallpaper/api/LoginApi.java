package com.ghost.mianmianwwallpaper.api;

import com.ghost.mianmianwwallpaper.commen.StringRequest;
import com.ghost.mianmianwwallpaper.interfaces.ResponseCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ghost on 2017/3/9.
 */

public class LoginApi {
    public static void getLoginService(String username, String passwd, ResponseCallback<String> responseCallback){
        StringRequest loginRequest = new StringRequest(responseCallback);
        Map<String,Object> loginParams = new HashMap<>();
        loginParams.put("act","login");
        loginParams.put("app","api_member");
        loginParams.put("phone",username);
        loginParams.put("password",passwd);
        loginRequest.get(loginParams);
    }
}
