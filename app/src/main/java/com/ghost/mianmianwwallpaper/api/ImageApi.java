package com.ghost.mianmianwwallpaper.api;

import com.ghost.mianmianwwallpaper.commen.StringRequest;
import com.ghost.mianmianwwallpaper.interfaces.ResponseCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hello on 2017/3/11.
 */

public class ImageApi {
    public static void getImageListService(String page, String tag, String tag2, ResponseCallback<String> responseCallback){
        StringRequest getImageListRequest = new StringRequest(responseCallback);
        Map<String,Object>getImageListParams =new HashMap<>();
        getImageListParams.put("pn",page);
        getImageListParams.put("rn","30");
        getImageListParams.put("tag1",tag);
        getImageListParams.put("tag2",tag2);
        getImageListParams.put("ie","utf-8");
        getImageListRequest.get(getImageListParams);
    }
}
