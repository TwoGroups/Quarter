package com.erzu.quarter.view.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.erzu.quarter.R;
import com.erzu.quarter.view.fragment.OddphotosFragment;
import com.erzu.quarter.view.fragment.RecommendFragment;
import com.erzu.quarter.view.fragment.JokesFragment;
import com.erzu.quarter.view.fragment.VideoFragment;
import com.hjm.bottomtabbar.BottomTabBar;

/**
 * 主页面
 */
public class MainActivity extends AppCompatActivity {
    BottomTabBar bottomTabBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomTabBar = findViewById(R.id.bottomTabBar);

        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(14)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("推荐",R.mipmap.ic_launcher, RecommendFragment.class)
                .addTabItem("段子",R.mipmap.ic_launcher, JokesFragment.class)
                .addTabItem("视频",R.mipmap.ic_launcher, VideoFragment.class)
                .addTabItem("趣图",R.mipmap.ic_launcher, OddphotosFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }
}
