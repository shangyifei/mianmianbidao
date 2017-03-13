package com.ghost.mianmianwwallpaper;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

/**
 * Created by hello on 2017/3/11.
 */

public class BaseErrorView extends FrameLayout {
    private Context mContext;
    public BaseErrorView(@NonNull Context context) {
        this(context,null);
    }

    public BaseErrorView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BaseErrorView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }
    private void init(){
        LayoutInflater.from(mContext).inflate(R.layout.errorview,this);
    }
}
