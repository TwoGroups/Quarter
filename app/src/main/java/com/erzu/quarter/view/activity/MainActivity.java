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
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * 主页面
 */
public class MainActivity extends AppCompatActivity {
    BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        bottomTabBar = findViewById(R.id.bottomTabBar);

        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(14)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("推荐", R.mipmap.ic_launcher, RecommendFragment.class)
                .addTabItem("段子", R.mipmap.ic_launcher, JokesFragment.class)
                .addTabItem("视频", R.mipmap.ic_launcher, VideoFragment.class)
                .addTabItem("趣图", R.mipmap.ic_launcher, OddphotosFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
        //new出SlidingMenu侧滑对象
        SlidingMenu menu = new SlidingMenu(this);
        //设置侧滑的方向.左侧
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        // 设置滑动完剩余的宽度
        menu.setBehindOffset(200);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        //绑定
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.sliding_left);
    }
}
