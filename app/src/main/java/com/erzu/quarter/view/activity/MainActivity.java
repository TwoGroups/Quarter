package com.erzu.quarter.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.view.fragment.JokesFragment;
import com.erzu.quarter.view.fragment.OddphotosFragment;
import com.erzu.quarter.view.fragment.RecommendFragment;
import com.erzu.quarter.view.fragment.VideoFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主页面
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.main_head_rl)
    RelativeLayout mainHeadRl;
    @BindView(R.id.main_bottomtabbar)
    BottomTabBar mainBottomtabbar;
    @BindView(R.id.main_simpledraweeview)
    SimpleDraweeView mainSimpledraweeview;
    @BindView(R.id.main_fb)
    ImageView mainFb;
    SlidingMenu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //隐藏标题栏
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        mainBottomtabbar.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(16)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.BLUE, Color.DKGRAY)
                .addTabItem("推荐", R.mipmap.recommend, RecommendFragment.class)
                .addTabItem("段子", R.mipmap.jokes, JokesFragment.class)
                .addTabItem("视频", R.mipmap.video, VideoFragment.class)
                .addTabItem("趣图", R.mipmap.oddphotos, OddphotosFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        if (name.equals("推荐")) {
                            mainTitle.setText("推荐");
                        } else if (name.equals("段子")) {
                            mainTitle.setText("段子");
                        } else if (name.equals("视频")) {
                            mainTitle.setText("视频");
                        } else if (name.equals("趣图")) {
                            mainTitle.setText("趣图");
                        }
                    }
                });

        //侧滑
        menu = new SlidingMenu(this);
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

    @OnClick({R.id.main_simpledraweeview, R.id.main_fb})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_simpledraweeview:
                //点击头像显示侧滑页面
                menu.showMenu();
                break;
            case R.id.main_fb:
                //点击跳转到创作页面
                Intent intent = new Intent(MainActivity.this,CreationActivity.class);
                startActivity(intent);
                break;
        }
    }
}
