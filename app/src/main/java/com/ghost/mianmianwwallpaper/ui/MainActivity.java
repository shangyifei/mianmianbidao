package com.ghost.mianmianwwallpaper.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ghost.mianmianwwallpaper.BaseActivity;
import com.ghost.mianmianwwallpaper.R;

import java.util.List;

import static com.ashokvarma.bottomnavigation.BottomNavigationBar.BACKGROUND_STYLE_STATIC;

public class MainActivity extends BaseActivity {
    private BottomNavigationBar mBottomNavigationBar;
    private FragmentManager mFragmentManager;
    private Class<Fragment>[] mContentArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mian);
        mBottomNavigationBar = findView(R.id.bottom_navigation_bar);
        setupContent();
        setupBottomBar();

    }
    private void setupBottomBar(){
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BACKGROUND_STYLE_STATIC);

        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_amber_a700_24dp,R.string.home).setActiveColor(getResources().getColor(android.R.color.holo_orange_light)))
                .addItem(new BottomNavigationItem(R.drawable.ic_search_orange_a700_24dp,R.string.find).setActiveColor(getResources().getColor(android.R.color.holo_orange_light)))
                .addItem(new BottomNavigationItem(R.drawable.ic_chrome_reader_mode_orange_a700_24dp,R.string.hotnews).setActiveColor(getResources().getColor(android.R.color.holo_orange_light)))
                .addItem(new BottomNavigationItem(R.drawable.ic_account_circle_orange_700_24dp,R.string.personal).setActiveColor(getResources().getColor(android.R.color.holo_orange_light)))
                .setFirstSelectedPosition(0)
                .initialise();
        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                try {
                    mFragmentManager.beginTransaction().replace(R.id.fl_fragment_container,mContentArray[position].newInstance()).commit();
                }catch (Exception e){}

            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }
    private void setupContent(){
        mContentArray = new Class[]{HomeFragment.class,FindFragment.class,HotNewsFragment.class,PersonalCenterFragment.class};
        mFragmentManager = getSupportFragmentManager();
        try {
            mFragmentManager.beginTransaction().replace(R.id.fl_fragment_container,mContentArray[0].newInstance()).commit();
        }catch (Exception e){
            System.out.println();
        }

    }



}
