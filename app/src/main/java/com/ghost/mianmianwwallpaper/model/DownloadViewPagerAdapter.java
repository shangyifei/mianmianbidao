package com.ghost.mianmianwwallpaper.model;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.ghost.mianmianwwallpaper.BasePagerAdapter;

import java.util.List;

/**
 * Created by Ghost on 2017/3/13.
 */

public class DownloadViewPagerAdapter extends BasePagerAdapter {
    public DownloadViewPagerAdapter(FragmentManager fm, List<Fragment> mFragments, String[] titles) {
        super(fm, mFragments, titles);
    }
}
