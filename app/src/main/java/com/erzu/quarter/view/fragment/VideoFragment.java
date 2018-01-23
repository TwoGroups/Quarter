package com.erzu.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.VideoRecommendBean;
import com.erzu.quarter.presenter.VideoPresenter;
import com.erzu.quarter.view.IMainView;
import com.erzu.quarter.view.adapter.RecommendRcyAdapter;
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

public class VideoFragment extends Fragment implements IMainView {
    @BindView(R.id.video_Tab)
    TabLayout videoTab;
    @BindView(R.id.video_viewPager)
    ViewPager videoViewPager;
    Unbinder unbinder;
    private VideoPagerAdapter pagerAdapter;
    private RecommendRcyAdapter rcyAdapter;
    private VideoPresenter presenter;
    private List<RecyclerView> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_video, null);
        unbinder = ButterKnife.bind(this, view);
        presenter = new VideoPresenter();
        presenter.attachView(this);
        Toast.makeText(getActivity(), "已创建", Toast.LENGTH_SHORT).show();
        presenter.loadDataFromServer();
        videoTab.setupWithViewPager(videoViewPager);
        List<View> list = new ArrayList<>();
        View recommend = View.inflate(getActivity(), R.layout.frag_recy_view, null);
        //        RecyclerView other = (RecyclerView) getLayoutInflater().inflate(R.layout.frag_recom_view, null);
        list.add(recommend);
        rcyAdapter = new RecommendRcyAdapter(getActivity());
        //设置adapter
        ((RecyclerView) recommend).setAdapter(rcyAdapter);
        pagerAdapter = new VideoPagerAdapter(getActivity(), list);
        videoViewPager.setAdapter(pagerAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.dettachView();
    }

    @Override
    public void onSuccess(VideoRecommendBean bean) {
        rcyAdapter.addData(bean);
    }
}
