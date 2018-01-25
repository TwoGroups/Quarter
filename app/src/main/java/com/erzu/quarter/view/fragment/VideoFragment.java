package com.erzu.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erzu.quarter.R;
import com.erzu.quarter.view.adapter.VideoPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 视频页面
 * Created by hp on 2018/1/19.
 */

public class VideoFragment extends Fragment {
    @BindView(R.id.video_Tab)
    TabLayout videoTab;
    @BindView(R.id.video_viewPager)
    ViewPager videoViewPager;
    Unbinder unbinder;
    private List<Fragment> list;
    private VideoPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_video, null);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        list = new ArrayList<>();
        list.add(new HotVideoFragment());
        list.add(new NearVideoFragment());
        List<String> title_list = new ArrayList<>();
        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        title_list.add("热门");
        title_list.add("附近");
        adapter = new VideoPagerAdapter(getChildFragmentManager(), list, title_list);
        videoViewPager.setAdapter(adapter);
        //设置TabLayout的模式
        videoTab.setTabMode(TabLayout.MODE_FIXED);
        videoTab.setupWithViewPager(videoViewPager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        //        presenter.dettachView();
    }
}
