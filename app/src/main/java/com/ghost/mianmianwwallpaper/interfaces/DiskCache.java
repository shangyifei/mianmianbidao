package com.ghost.mianmianwwallpaper.interfaces;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * Created by Ghost on 2017/3/13.
 */

public interface DiskCache {
    public boolean save(String imageUrl, Bitmap bitmap, BitmapFactory.Options decodeoptions) throws IOException;
    public boolean save(String imageUri, InputStream imageStream) throws IOException;
    public File get(String imageUrl);
}
