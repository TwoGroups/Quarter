package com.erzu.quarter.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.view.fragment.JokesFragment;
import com.erzu.quarter.view.fragment.OddphotosFragment;
import com.erzu.quarter.view.fragment.RecommendFragment;
import com.erzu.quarter.view.fragment.VideoFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主页面
 */
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.main_head_rl)
    RelativeLayout mainHeadRl;
    @BindView(R.id.main_fl)
    FrameLayout mainFl;
    @BindView(R.id.recommend)
    RadioButton recommend;
    @BindView(R.id.jokes)
    RadioButton jokes;
    @BindView(R.id.video)
    RadioButton video;
    @BindView(R.id.oddphotos)
    RadioButton oddphotos;
    @BindView(R.id.main_rg)
    RadioGroup mainRg;
    List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //隐藏标题栏
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        list = new ArrayList<>();
        RecommendFragment recommendFragment = new RecommendFragment();
        JokesFragment jokesFragment = new JokesFragment();
        VideoFragment videoFragment = new VideoFragment();
        OddphotosFragment oddphotosFragment = new OddphotosFragment();
        list.add(recommendFragment);
        list.add(jokesFragment);
        list.add(videoFragment);
        list.add(oddphotosFragment);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl, list.get(0)).commit();
        //radiogroup的点击事件
        mainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            int currentPosition = 0;

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.recommend:
                        currentPosition = 0;
                        mainTitle.setText("推荐");
                        break;
                    case R.id.jokes:
                        currentPosition = 1;
                        mainTitle.setText("段子");
                        break;
                    case R.id.video:
                        currentPosition = 2;
                        mainTitle.setText("视频");
                        break;
                    case R.id.oddphotos:
                        currentPosition = 3;
                        mainTitle.setText("趣图");
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fl, list.
                        get(currentPosition)).commit();
            }
        });

        //侧滑
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
