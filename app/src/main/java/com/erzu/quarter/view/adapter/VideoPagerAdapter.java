package com.erzu.quarter.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by War on 2018/1/22.
 */

public class VideoPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private List<String> title_list;

    public VideoPagerAdapter(FragmentManager fm, List<Fragment> list, List<String> title_list) {
        super(fm);
        this.list = list;
        this.title_list = title_list;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title_list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }
}
