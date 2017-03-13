package com.ghost.mianmianwwallpaper.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.ghost.mianmianwwallpaper.BaseActivity;
import com.ghost.mianmianwwallpaper.R;
import com.ghost.mianmianwwallpaper.commen.ImageLoader;
import com.ghost.mianmianwwallpaper.commen.ImageRequest;
import com.ghost.mianmianwwallpaper.commen.SettingShadow;
import com.ghost.mianmianwwallpaper.interfaces.ResponseCallback;
import com.ghost.mianmianwwallpaper.model.WallPaper;

public class ImageDetailsActivity extends BaseActivity {
    private ImageView mDisplayImage;
    private String mImageUrl;
    private WallPaper mWallPaper;
    private Button mSetWallpaper;
    private SettingShadow mSettingShadow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);
        setupView();

    }
    private void setupView(){
        mSettingShadow = new SettingShadow(this);
        mImageUrl = getIntent().getStringExtra("image_url");
        mDisplayImage = findView(R.id.iv_display_image);
        ImageLoader.getInstance().displayImage(mImageUrl,mDisplayImage);
        mWallPaper = new WallPaper(this);
//        wallPaper.setWapppaper(((BitmapDrawable)mDisplayImage.getDrawable()).getBitmap());
        mSetWallpaper = findView(R.id.btn_set_wallpaper);
        mSetWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSetWallpaper.setEnabled(false);
                mSettingShadow.startShadow();
                ImageRequest imageRequest = new ImageRequest(new ResponseCallback<Bitmap>() {
                    @Override
                    public void onSuccess(Bitmap entity) {

                        mWallPaper.setWapppaper(((BitmapDrawable)mDisplayImage.getDrawable()).getBitmap());
                        mSettingShadow.stopShadow();
                        mSetWallpaper.setEnabled(true);
                    }

                    @Override
                    public void onFail(int error) {
                        mSettingShadow.stopShadow();
                        mSetWallpaper.setEnabled(true);
                    }
                });
                imageRequest.downImage(mImageUrl,0,0);
            }
        });
        findView(R.id.fl_back_container).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findView(R.id.fl_folder_container).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ImageDetailsActivity.this,DownloadManagerActivity.class));
            }
        });
        mDisplayImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImageDetailsActivity.this,ShowOriginalImageActivity.class);
                intent.putExtra("image_url",mImageUrl);
                startActivity(intent);

            }
        });
    }
}
