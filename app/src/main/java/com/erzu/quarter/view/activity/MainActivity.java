package com.erzu.quarter.view.activity;

import android.accounts.Account;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.EventBeanLogin;
import com.erzu.quarter.utils.SharedPrefsUtil;
import com.erzu.quarter.utils.nightmodel.ThemeManager;
import com.erzu.quarter.view.fragment.JokesFragment;
import com.erzu.quarter.view.fragment.OddphotosFragment;
import com.erzu.quarter.view.fragment.RecommendFragment;
import com.erzu.quarter.view.fragment.VideoFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.suke.widget.SwitchButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主页面
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, ThemeManager.OnThemeChangeListener {

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
    View view;
    @BindView(R.id.mian_relativelayout)
    RelativeLayout mianRelativelayout;
    private ActionBar supportActionBar;
    SwitchButton main_night_button;
    RelativeLayout left_relativelayout;
    ImageView left_night;
    private int indexes;
    private SimpleDraweeView left_tx;
    private TextView left_usersname;
    private String nickName;
    private String pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
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
                    public void onTabChange(int position, final String name) {
                        indexes = position;
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
        // 设置滑动完剩余的宽度
        menu.setBehindOffset(200);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        //绑定
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        view = View.inflate(this, R.layout.sliding_left, null);
        menu.setMenu(view);
        //实例化控件
        initView();
        left_usersname.setText(SharedPrefsUtil.getValue(this, "Account","username","游客12306"));
        //夜间模式
        ThemeManager.registerThemeChangeListener(this);
        supportActionBar = getSupportActionBar();
        main_night_button.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (isChecked) {
                    //开启夜间模式
                    left_night.setImageResource(R.mipmap.night_open);
                    ThemeManager.setThemeMode(ThemeManager.getThemeMode() == ThemeManager.ThemeMode.DAY
                            ? ThemeManager.ThemeMode.NIGHT : ThemeManager.ThemeMode.DAY);
                } else {
                    //关闭夜间模式
                    left_night.setImageResource(R.mipmap.night_colse);
                    ThemeManager.setThemeMode(ThemeManager.getThemeMode() == ThemeManager.ThemeMode.DAY
                            ? ThemeManager.ThemeMode.NIGHT : ThemeManager.ThemeMode.DAY);
                }
            }
        });
    }

    private void initView() {
        LinearLayout left_login = view.findViewById(R.id.left_login);
        left_tx = view.findViewById(R.id.left_tx);
        left_usersname = view.findViewById(R.id.left_usersname);
        LinearLayout left_attention = view.findViewById(R.id.left_attention);
        LinearLayout left_collect = view.findViewById(R.id.left_collect);
        LinearLayout left_search = view.findViewById(R.id.left_search);
        LinearLayout left_message = view.findViewById(R.id.left_message);
        LinearLayout left_production = view.findViewById(R.id.left_production);
        LinearLayout left_sz = view.findViewById(R.id.left_sz);
        left_login.setOnClickListener(this);
        left_attention.setOnClickListener(this);
        left_collect.setOnClickListener(this);
        left_search.setOnClickListener(this);
        left_message.setOnClickListener(this);
        left_production.setOnClickListener(this);
        left_sz.setOnClickListener(this);
        //夜间模式按钮
        main_night_button = view.findViewById(R.id.main_night_button);
        left_relativelayout = view.findViewById(R.id.left_relativelayout);
        left_night = view.findViewById(R.id.left_night);
    }

    /**
     * 接受登陆界面传来的网名与头像
     *
     * @param eventBeanLogin
     */
    @Subscribe(sticky = true)
    public void eventBus(EventBeanLogin eventBeanLogin) {
        pic = eventBeanLogin.getPic();
        nickName = eventBeanLogin.getNickName();

        Log.e("", "头像" + pic);
        Log.e("", "网名: " + nickName);
        //展示网名头像
        left_usersname.setText(nickName);
        left_tx.setImageURI(pic);
        mainSimpledraweeview.setImageURI(pic);
        Log.e("", "-----------" + nickName);
    }


    @OnClick({R.id.main_simpledraweeview, R.id.main_fb})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_simpledraweeview:
                //点击头像显示侧滑页面
                menu.showMenu();
                break;
            case R.id.main_fb:
                if (indexes == 3) {
                    //点击跳转到发表页面
                    Intent intent = new Intent(MainActivity.this, WriteJokeActivity.class);
                    startActivity(intent);
                } else {
                    //点击跳转到创作页面
                    Intent intent = new Intent(MainActivity.this, CreationActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_login:
                //点击头像用户名跳转到登录页面
                Intent intentlogin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intentlogin);
                break;
            case R.id.left_attention:
                //点击跳转到我的关注页面
                Intent intentattention = new Intent(MainActivity.this, AttentionActivity.class);
                startActivity(intentattention);
                break;
            case R.id.left_collect:
                //点击跳转到我的收藏页面
                Intent intentcollect = new Intent(MainActivity.this, CollectActivity.class);
                startActivity(intentcollect);
                break;
            case R.id.left_search:
                //点击跳转到搜索好友页面
                Intent intentsearch = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intentsearch);
                break;
            case R.id.left_message:
                //点击跳转到消息通知页面
                Intent intentmessage = new Intent(MainActivity.this, MessageActivity.class);
                startActivity(intentmessage);
                break;
            case R.id.left_production:
                //点击跳转到我的作品页面
                Intent intentproduction = new Intent(MainActivity.this, ProductionActivity.class);
                startActivity(intentproduction);
                break;
            case R.id.left_sz:
                //点击跳转到设置页面
                Intent intentset = new Intent(MainActivity.this, SetActivity.class);
                startActivity(intentset);
                break;
        }
    }

    //夜间模式
    public void initTheme() {

        mianRelativelayout.setBackgroundColor(getResources().getColor(ThemeManager.
                getCurrentThemeRes(MainActivity.this, R.color.backgroundColor)));
        //        mainHeadRl.setBackgroundColor(getResources().getColor(ThemeManager.
        //                getCurrentThemeRes(MainActivity.this, R.color.backgroundColor)));
        left_relativelayout.setBackgroundColor(getResources().getColor(ThemeManager.
                getCurrentThemeRes(MainActivity.this, R.color.backgroundColor)));
        //消息页面夜间模式
        //        MessageActivity messageActivity = new MessageActivity();
        //        messageActivity.MessageNight();
        // 设置标题栏颜色
        if (supportActionBar != null) {
            supportActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.colorPrimary))));
        }
        // 设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(getResources().getColor(ThemeManager.getCurrentThemeRes(MainActivity.this, R.color.colorPrimary)));
        }
    }

    @Override
    public void onThemeChanged() {
        initTheme();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ThemeManager.unregisterThemeChangeListener(this);
        EventBus.getDefault().unregister(this);
    }

}
