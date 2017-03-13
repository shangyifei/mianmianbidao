package com.ghost.mianmianwwallpaper.commen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

import com.ghost.mianmianwwallpaper.MianMianWallpaperApplication;
import com.ghost.mianmianwwallpaper.interfaces.DiskCache;
import com.ghost.mianmianwwallpaper.interfaces.IRequest;
import com.ghost.mianmianwwallpaper.interfaces.ResponseCallback;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


/**
 * Created by hello on 2017/3/11.
 */

public class ImageRequest implements IRequest {
    private ResponseCallback<Bitmap> mResponseCallback;
    private static final Object sDecodeLock = new Object();
    private DiskCache diskCache;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1){
                mResponseCallback.onSuccess((Bitmap)msg.obj);
            }
            return true;
        }
    });

    public ImageRequest(ResponseCallback<Bitmap> mResponseCallback) {
        this.mResponseCallback = mResponseCallback;
        diskCache = new BaseDiskCache(new File(MianMianWallpaperApplication.getInstance().getCacheDir().getAbsoluteFile(),"ghostimagcache"));
        System.out.println();
    }

    @Override
    public Map<String, Object> getParams() {
        return null;
    }

    @Override
    public String getBaseUrl() {
        return null;
    }

    @Override
    public String getMothed() {
        return null;
    }

    @Override
    public Map<String, String> getHeader() {
        return null;
    }
    public void downImage(final String url, final int maxwidth, final int maxHeight){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Bitmap bitmap = null;
                    Message msg = handler.obtainMessage();
                    File file = diskCache.get(url);
                    if (file.exists()){
                        synchronized (sDecodeLock) {
                            BitmapFactory.Options decodeOptions = new BitmapFactory.Options();
                            bitmap = doParse(TextUtils.getBytesByInputStream(new FileInputStream(file)), maxwidth, maxHeight,decodeOptions);
                            if (bitmap != null) {
                                msg.what = 1;
                                msg.obj = bitmap;
                                handler.sendMessage(msg);
                            } else {
                                msg.what = 2;
                                handler.sendMessage(msg);
                            }
                        }
                    }else {
                        URL imagePath = new URL(url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) imagePath.openConnection();
                        httpURLConnection.setConnectTimeout(6000);
                        if (httpURLConnection.getResponseCode() == 200) {

                            InputStream is = httpURLConnection.getInputStream();
                            if (is == null) {
                                throw new Exception("stream is null!");
                            } else {
                                BitmapFactory.Options decodeOptions = new BitmapFactory.Options();
                                synchronized (sDecodeLock) {
                                    byte[] bytes = TextUtils.getBytesByInputStream(is);
                                    bitmap = doParse(bytes, maxwidth, maxHeight,decodeOptions);
                                    if (bitmap != null) {
                                        msg.what = 1;
                                        msg.obj = bitmap;
                                        handler.sendMessage(msg);
                                    } else {
                                        msg.what = 2;
                                        handler.sendMessage(msg);
                                    }
                                }
                                diskCache.save(url,bitmap,decodeOptions);
                            }

                        } else {
                            msg.what = 2;
                            handler.sendMessage(msg);
                        }
                    }
//                    if (bitmap != null) {
//                        msg.what = 1;
//                        msg.obj = bitmap;
//                        handler.sendMessage(msg);
//                    } else {
//                        msg.what = 2;
//                        handler.sendMessage(msg);
//                    }
                }catch (Exception e){
                    System.out.println();
                }

            }
        }).start();
    }
    private Bitmap doParse(byte[] data, int maxwidth, int maxheight, BitmapFactory.Options decodeOptions) {
        Bitmap bitmap = null;
        if (maxheight == 0 && maxheight == 0) {
            decodeOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length, decodeOptions);
            BitmapFactory.Options op = decodeOptions;
            System.out.println();
        } else {
            // If we have to resize this image, first get the natural bounds.
            decodeOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(data, 0, data.length, decodeOptions);
            int actualWidth = decodeOptions.outWidth;
            int actualHeight = decodeOptions.outHeight;

            // Then compute the dimensions we would ideally like to decode to.
            int desiredWidth = getResizedDimension(maxwidth,maxheight,
                    actualWidth, actualHeight);
            int desiredHeight = getResizedDimension(maxheight,maxwidth,
                    actualHeight, actualWidth);

            // Decode to the nearest power of two scaling factor.
            decodeOptions.inJustDecodeBounds = false;
            // TODO(ficus): Do we need this or is it okay since API 8 doesn't support it?
            // decodeOptions.inPreferQualityOverSpeed = PREFER_QUALITY_OVER_SPEED;
            decodeOptions.inSampleSize =
                    findBestSampleSize(actualWidth, actualHeight, desiredWidth, desiredHeight);
            Bitmap tempBitmap =
                    BitmapFactory.decodeByteArray(data, 0, data.length, decodeOptions);

            // If necessary, scale down to the maximal acceptable size.
            if (tempBitmap != null && (tempBitmap.getWidth() > desiredWidth ||
                    tempBitmap.getHeight() > desiredHeight)) {
                bitmap = Bitmap.createScaledBitmap(tempBitmap,
                        desiredWidth, desiredHeight, true);
                tempBitmap.recycle();
            } else {
                bitmap = tempBitmap;
            }
        }

        if (bitmap == null) {
            return null;
        } else {
            return bitmap;
        }
    }
    static int findBestSampleSize(
            int actualWidth, int actualHeight, int desiredWidth, int desiredHeight) {
        double wr = (double) actualWidth / desiredWidth;
        double hr = (double) actualHeight / desiredHeight;
        double ratio = Math.min(wr, hr);
        float n = 1.0f;
        while ((n * 2) <= ratio) {
            n *= 2;
        }

        return (int) n;
    }
    private static int getResizedDimension(int maxPrimary, int maxSecondary, int actualPrimary,
                                           int actualSecondary) {

        // If no dominant value at all, just return the actual.
        if ((maxPrimary == 0) && (maxSecondary == 0)) {
            return actualPrimary;
        }

        // If ScaleType.FIT_XY fill the whole rectangle, ignore ratio.

            if (maxPrimary == 0) {
                return actualPrimary;
            }
            return maxPrimary;


    }
}
