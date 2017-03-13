package com.ghost.mianmianwwallpaper.commen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.ghost.mianmianwwallpaper.interfaces.DiskCache;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Ghost on 2017/3/13.
 */

public class BaseDiskCache implements DiskCache {
    public static final int DEFAULT_BUFFER_SIZE = 32 * 1024; // 32 Kb
    private File cacheDir;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    protected Bitmap.CompressFormat compressFormat = DEFAULT_COMPRESS_FORMAT;
    protected int compressQuality = DEFAULT_COMPRESS_QUALITY;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    public int bufferSize = DEFAULT_BUFFER_SIZE;

    public BaseDiskCache(File cacheDir) {
        this.cacheDir = cacheDir;
    }

    @Override
    public boolean save(String imageUrl, Bitmap bitmap, BitmapFactory.Options decodeoptions) throws IOException{
        File file = getFile(imageUrl);
        File tmpFile = new File(file.getAbsolutePath() + ".tmp");
        OutputStream os = new BufferedOutputStream(new FileOutputStream(tmpFile), bufferSize);
        boolean savedSuccessfully = false;
        try {
            savedSuccessfully = bitmap.compress(TextUtils.getFormatFromMime(decodeoptions.outMimeType), compressQuality, os);

        } finally {
            os.close();
            if (savedSuccessfully && !tmpFile.renameTo(file)) {
                savedSuccessfully = false;
            }
            if (!savedSuccessfully) {
                tmpFile.delete();
            }
        }
//        bitmap.recycle();
//        bitmap();
        return savedSuccessfully;
    }
    public boolean save(String imageUri, InputStream imageStream) throws IOException {
        File imageFile = getFile(imageUri);
        File tmpFile = new File(imageFile.getAbsolutePath() + ".tmp");
        boolean loaded = false;
        try {
            OutputStream os = new BufferedOutputStream(new FileOutputStream(tmpFile), bufferSize);
            try {
                loaded = TextUtils.copyStream(imageStream, os, bufferSize);
            } finally {
                os.close();
            }
        } finally {
            if (loaded && !tmpFile.renameTo(imageFile)) {
                loaded = false;
            }
            if (!loaded) {
                tmpFile.delete();
            }
        }
        return loaded;
    }

    @Override
    public File get(String imageUrl) {
        return getFile(imageUrl);
    }

    protected File getFile(String imageUri) {
        String fileName = HashFileNameGenerator.generate(imageUri);
        File dir = cacheDir;
        if (!cacheDir.exists() && !cacheDir.mkdirs()) {
//            if (reserveCacheDir != null && (reserveCacheDir.exists() || reserveCacheDir.mkdirs())) {
//                dir = reserveCacheDir;
//            }
        }
        return new File(dir, fileName);
    }
}
