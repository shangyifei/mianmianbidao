package com.ghost.mianmianwwallpaper.commen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import com.ghost.mianmianwwallpaper.interfaces.ResponseCallback;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hello on 2017/3/11.
 */

public class ImageLoader {
    static ImageLoader instance;
    private Context mContext;
    public static synchronized ImageLoader getInstance(){
        if (instance == null){
            instance = new ImageLoader();
        }
        return instance;
    }
//    static Handler handler = new Handler(new Handler.Callback() {
//        @Override
//        public boolean handleMessage(Message msg) {
//            if (msg.what == 1){
//                synchronized (handler){
//                ((ImageView)msg.obj).setAlpha(msg.getData().getFloat("alpha"));}
//            }
//            return true;
//        }
//    });
    public void displayImage(String url, final ImageView imageView){
        ImageRequest imageRequest = new ImageRequest(new ResponseCallback<Bitmap>() {
            @Override
            public void onSuccess(Bitmap entity) {
                imageView.setImageBitmap(entity);
//                final Timer timer = new Timer();
//                timer.schedule(new TimerTask() {
//                    float delalpha = 0;
//                    @Override
//                    public void run() {
//                        if (delalpha==1.00){
//                            cancel();
//                        }
//                        delalpha += 0.01;
//                        System.out.println(delalpha);
//                        Message msg = handler.obtainMessage();
//                        Bundle bundle = new Bundle();
//                        bundle.putFloat("alpha",delalpha);
//                        msg.obj = imageView;
//                        msg.what = 1;
//                        msg.setData(bundle);
//                        handler.sendMessage(msg);
//                    }
//                },0,10);
                //imageView.startAnimation(alphaAnimation);
            }

            @Override
            public void onFail(int error) {

            }
        });
        imageRequest.downImage(url,0,0);
    }
    private Bitmap adjustBitmapSize(Bitmap orginal,int orwidth,int orheight){
        // 获得图片的宽高
        int width = orginal.getWidth();
        int height = orginal.getHeight();
        System.out.println(width+"::::"+height);
        // 计算缩放比例
        float scaleWidth = ((float) orwidth) / width;
        float scaleHeight = ((float) orheight) / height;
        // 取得想要缩放的matrix参数
         Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片   www.2cto.com
        Bitmap newbm = Bitmap.createBitmap(orginal, 0, 0, width, height, matrix, true);
        return newbm;
    }
}
