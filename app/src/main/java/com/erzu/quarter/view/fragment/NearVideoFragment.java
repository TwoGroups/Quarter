package com.erzu.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.HotVideoBean;
import com.erzu.quarter.presenter.VideoPresenter;
import com.erzu.quarter.view.IView.IVideoView;
import com.erzu.quarter.view.adapter.HotVideoAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by War on 2018/1/23.
 */

public class NearVideoFragment extends Fragment implements IVideoView {

    @BindView(R.id.frag_near_view)
    RecyclerView fragNearView;
    Unbinder unbinder;
    private HotVideoAdapter adapter;
    private VideoPresenter presenter;
    private int size = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.frag_near_video, null);
        unbinder = ButterKnife.bind(this, view);
        Toast.makeText(getActivity(), "Near", Toast.LENGTH_SHORT).show();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new HotVideoAdapter(getActivity());
        fragNearView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        fragNearView.setAdapter(adapter);
        presenter = new VideoPresenter(this);
        presenter.getHotVideoData(size + "");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onSucceed(HotVideoBean videosBean) {
        adapter.addData(videosBean);
        System.out.println("----"+videosBean.toString());
    }

    @Override
    public void onFailure(Exception e) {

    }
}
