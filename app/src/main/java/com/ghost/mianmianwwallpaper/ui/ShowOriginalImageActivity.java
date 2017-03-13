package com.ghost.mianmianwwallpaper.ui;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.ghost.mianmianwwallpaper.BaseActivity;
import com.ghost.mianmianwwallpaper.R;

public class ShowOriginalImageActivity extends BaseActivity {
    private ImageView mOriginalImage;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_original_image);
        mOriginalImage = findView(R.id.iv_original_image);
        bitmap = getIntent().getParcelableExtra("bitmap");
        mOriginalImage.setImageBitmap(bitmap);
    }
}
