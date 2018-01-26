package com.erzu.quarter.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.erzu.quarter.R;
import com.erzu.quarter.utils.nightmodel.ThemeManager;
import com.erzu.quarter.view.fragment.MessageFragment;
import com.erzu.quarter.view.fragment.PersonalFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageActivity extends AppCompatActivity {

    @BindView(R.id.message_back)
    LinearLayout messageBack;
    @BindView(R.id.message_tab)
    TabLayout messageTab;
    @BindView(R.id.message_viewpager)
    ViewPager messageViewpager;
    List<Fragment> messageFragment;
    List<String> messageTitle;
    LinearLayout message_linearlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        initFragment();
        message_linearlayout = findViewById(R.id.message_linearlayout);
    }

//    public void MessageNight() {
//        message_linearlayout.setBackgroundColor(getResources().getColor(ThemeManager.
//                getCurrentThemeRes(MessageActivity.this, R.color.backgroundColor)));
//    }

    private void initFragment() {
        messageFragment = new ArrayList<>();
        messageFragment.add(new MessageFragment());
        messageFragment.add(new PersonalFragment());

        messageTitle = new ArrayList<>();
        messageTitle.add("消息");
        messageTitle.add("私信");
        //设置TabLayout的模式
        messageTab.setTabMode(TabLayout.MODE_FIXED);
        messageTab.addTab(messageTab.newTab().setText(messageTitle.get(0)));
        messageTab.addTab(messageTab.newTab().setText(messageTitle.get(1)));
        Viewpageradapter viewpager = new Viewpageradapter(getSupportFragmentManager());
        messageViewpager.setAdapter(viewpager);
        messageTab.setupWithViewPager(messageViewpager);
    }

    @OnClick(R.id.message_back)
    public void onViewClicked() {
        finish();
    }

    private class Viewpageradapter extends FragmentPagerAdapter {

        public Viewpageradapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return messageTitle.size();
        }

        @Override
        public Fragment getItem(int position) {
            return messageFragment.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return messageTitle.get(position % messageTitle.size());
        }
    }
}
