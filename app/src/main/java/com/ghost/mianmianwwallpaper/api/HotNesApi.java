package com.ghost.mianmianwwallpaper.api;

import com.ghost.mianmianwwallpaper.commen.StringRequest;
import com.ghost.mianmianwwallpaper.interfaces.ResponseCallback;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by hello on 2017/3/11.
 */

public class HotNesApi {
    public static void getHotNewsService (String type,String page,ResponseCallback<String> responseCallback){
        StringRequest getHotNewsRequest = new StringRequest(responseCallback);
        Map<String,Object> getHotNewsParams = new HashMap<>();
        getHotNewsParams.put("type",type);
        getHotNewsParams.put("page",page);
        getHotNewsParams.put("limit","12");
        getHotNewsRequest.get(getHotNewsParams);
    }
}
