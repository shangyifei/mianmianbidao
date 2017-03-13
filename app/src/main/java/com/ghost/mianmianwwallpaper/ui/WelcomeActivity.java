package com.ghost.mianmianwwallpaper.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.TextView;

import com.ghost.mianmianwwallpaper.BaseActivity;
import com.ghost.mianmianwwallpaper.R;

/**
 * Created by Ghost on 2017/3/9.
 */

public class WelcomeActivity extends BaseActivity implements Animation.AnimationListener{
    private TextView mCommentTv;
    private AlphaAnimation mCommentVisibleAnim;
    private AlphaAnimation mCommentInvisibleAnim;
    private AnimationSet mCommentVisibleAnimSet;
    private String[] mComments = new String[]{"您好","欢迎来到","面面壁到","我们将为您开启","不一样的精彩!"};
    private int mRepeatIndex;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mCommentTv = findView(R.id.tv_comment);
        mCommentTv.setText(mComments[0]);
        mCommentTv.setVisibility(View.INVISIBLE);
        setupAnim();
    }
    private void setupAnim(){
        mCommentVisibleAnimSet = new AnimationSet(true);
        mCommentVisibleAnimSet.setDuration(2000);
        mCommentVisibleAnim = new AlphaAnimation(0,1);
        mCommentInvisibleAnim = new AlphaAnimation(1,0);
        mCommentVisibleAnimSet.addAnimation(mCommentVisibleAnim);
        mCommentVisibleAnimSet.addAnimation(mCommentInvisibleAnim);
        mCommentVisibleAnimSet.setAnimationListener(this);
        mCommentTv.startAnimation(mCommentVisibleAnimSet);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        mRepeatIndex++;
        if (mRepeatIndex < mComments.length) {
            setupAnim();
            mCommentTv.setText(mComments[mRepeatIndex]);
            mCommentTv.startAnimation(mCommentVisibleAnimSet);
        }else {
            startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
            overridePendingTransition(R.anim.fist_open_login,0);
            finish();
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
