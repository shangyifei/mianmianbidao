package com.ghost.mianmianwwallpaper.ui;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.ghost.mianmianwwallpaper.BaseActivity;
import com.ghost.mianmianwwallpaper.R;
import com.ghost.mianmianwwallpaper.commen.ImageRequest;
import com.ghost.mianmianwwallpaper.interfaces.ResponseCallback;

public class ShowOriginalImageActivity extends BaseActivity {
    private ImageView mOriginalImage;
    private String mImageUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_original_image);
        mOriginalImage = findView(R.id.iv_original_image);
        mImageUrl = getIntent().getStringExtra("image_url");
        ImageRequest imageRequest = new ImageRequest(new ResponseCallback<Bitmap>() {
            @Override
            public void onSuccess(Bitmap entity) {
                mOriginalImage.setImageBitmap(entity);
            }

            @Override
            public void onFail(int error) {

            }
        });
        imageRequest.downImage(mImageUrl,0,0);
    }
}
