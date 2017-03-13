package com.ghost.mianmianwwallpaper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Ghost on 2017/3/13.
 */

public class BasePagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private String[] titles = new String[]{"壁纸","锁屏"};
    public BasePagerAdapter(FragmentManager fm, List<Fragment> mFragments,String[] titles) {
        super(fm);
        this.mFragments = mFragments;
        this.titles = titles;
    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
