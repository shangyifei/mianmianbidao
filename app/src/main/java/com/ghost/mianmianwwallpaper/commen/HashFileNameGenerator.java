package com.ghost.mianmianwwallpaper.commen;

/**
 * Created by Ghost on 2017/3/13.
 */

public class HashFileNameGenerator {
    static String generate(String imageUri){
        return String.valueOf(imageUri.hashCode());
    }
}
