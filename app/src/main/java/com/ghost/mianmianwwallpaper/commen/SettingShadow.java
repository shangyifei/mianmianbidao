package com.ghost.mianmianwwallpaper.commen;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.ghost.mianmianwwallpaper.R;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hello on 2017/3/12.
 */

public class SettingShadow {
    private View mShadowView;
    FrameLayout frameLayout ;
    private Context mContext;
    Lock mLock = new ReentrantLock();
    public SettingShadow(Activity activity) {
        mContext = activity;
        frameLayout = (FrameLayout) activity.findViewById(android.R.id.content);
    }

    public void startShadow(){
        mShadowView = LayoutInflater.from(mContext).inflate(R.layout.setting_shade,frameLayout,false);
        mShadowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        frameLayout.addView(mShadowView);
    }
    public void stopShadow(){
        frameLayout.removeView(mShadowView);
    }
}
