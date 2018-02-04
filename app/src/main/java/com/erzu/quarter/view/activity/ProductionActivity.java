package com.erzu.quarter.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.erzu.quarter.R;
import com.erzu.quarter.view.fragment.AlreadyuploadedFragment;
import com.erzu.quarter.view.fragment.LocalWorkFragment;

import java.util.ArrayList;
import java.util.List;

public class ProductionActivity extends AppCompatActivity {

    private LinearLayout mBackSearch;
    private TabLayout mLayoutTab;
    private ViewPager mPagerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production);
        initView();


        mBackSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final List<String> list = new ArrayList<>();

        //添加4条数据,作为tablayout标签
        list.add("本地作品");
        list.add("已上传");
        mLayoutTab.setTabMode(TabLayout.MODE_FIXED);
        //设置viewpager可以预加载全部得页数，不会销毁其他页数
        mPagerView.setOffscreenPageLimit(list.size());
        mPagerView.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            private LocalWorkFragment localWorkFragment;
            private AlreadyuploadedFragment alreadyuploadedFragment;

            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    localWorkFragment = new LocalWorkFragment();
                    return localWorkFragment;
                } else {
                    alreadyuploadedFragment = new AlreadyuploadedFragment();
                    return alreadyuploadedFragment;
                }
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        mLayoutTab.setupWithViewPager(mPagerView);
    }

    private void initView() {
        mBackSearch = (LinearLayout) findViewById(R.id.search_back);
        mLayoutTab = (TabLayout) findViewById(R.id.tab_layout);
        mPagerView = (ViewPager) findViewById(R.id.view_pager);
    }
}
