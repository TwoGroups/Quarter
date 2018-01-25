package com.erzu.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.RecommendVideoBean;
import com.erzu.quarter.presenter.VideoPresenter;
import com.erzu.quarter.view.IView.IVideoView;
import com.erzu.quarter.view.adapter.HotVideoAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 热门
 * Created by War on 2018/1/23.
 */

public class HotVideoFragment extends Fragment implements IVideoView {
    @BindView(R.id.frag_hot_view)
    XRecyclerView fragHotView;
    Unbinder unbinder;
    private VideoPresenter presenter;
    private int size = 1;
    private HotVideoAdapter adapter;
    private List<RecommendVideoBean.DataBean> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.frag_hot_video, null);
        unbinder = ButterKnife.bind(this, view);
        data = new ArrayList<>();
        fragHotView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        fragHotView.setPullRefreshEnabled(true);
        fragHotView.setLoadingMoreEnabled(true);
        presenter = new VideoPresenter(this);
        presenter.getHotVideoData(size + "");
        fragHotView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                fragHotView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                size++;
                presenter.getHotVideoData(size + "");
            }
        });
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onSucceed(RecommendVideoBean videosBean) {
        fragHotView.loadMoreComplete();
        data.addAll(videosBean.getData());
        adapter = new HotVideoAdapter(getActivity(), data);
        fragHotView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(Exception e) {

    }
}
