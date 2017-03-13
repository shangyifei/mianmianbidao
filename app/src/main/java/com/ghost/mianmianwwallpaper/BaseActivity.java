package com.ghost.mianmianwwallpaper;

import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;

import com.ghost.mianmianwwallpaper.commen.KeyboardManager;

/**
 * Created by Ghost on 2017/3/9.
 */

public class BaseActivity extends FragmentActivity {
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        KeyboardManager.hideKeyboard(BaseActivity.this);
        return super.onTouchEvent(event);
    }
    public  <T extends View>  T findView(int resid){
        return (T)findViewById(resid);
    }
}
