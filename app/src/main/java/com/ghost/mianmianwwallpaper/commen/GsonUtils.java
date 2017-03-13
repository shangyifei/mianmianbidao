package com.ghost.mianmianwwallpaper.commen;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by Ghost on 2017/3/10.
 */

public class GsonUtils {
    public static <T> T gsonParase(String data, Type type){
        Gson gson = new Gson();
        return gson.fromJson(data,type);
    }
    public static <T> T gsonParase(String data, Class clazz){
        Gson gson = new Gson();
        return (T)gson.fromJson(data,clazz);
    }
}
