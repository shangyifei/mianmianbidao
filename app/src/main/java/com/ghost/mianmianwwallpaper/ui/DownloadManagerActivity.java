package com.ghost.mianmianwwallpaper.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ghost.mianmianwwallpaper.BaseActivity;
import com.ghost.mianmianwwallpaper.R;
import com.ghost.mianmianwwallpaper.model.DownloadViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class DownloadManagerActivity extends BaseActivity {
    private TabLayout mTabLayout;
    private ViewPager mDownloadManagerVp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_manager);
        setupTabLayout();
    }
    private void setupTabLayout(){
        mTabLayout = findView(R.id.tl_download_manager);
//        mTabLayout.addTab(mTabLayout.newTab().setText("壁纸"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("锁屏"));
        setupViewpage();
    }
    private void   setupViewpage(){
        mDownloadManagerVp = findView(R.id.vp_download);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new DownloadWallpaperFragment());
        fragments.add(new DownloadLockScreenFragment());
        DownloadViewPagerAdapter downloadViewPagerAdapter = new DownloadViewPagerAdapter(getSupportFragmentManager(),fragments,new String[]{"壁纸","锁屏"});
        mDownloadManagerVp.setAdapter(downloadViewPagerAdapter);
        mTabLayout.setupWithViewPager(mDownloadManagerVp);
    }
}
