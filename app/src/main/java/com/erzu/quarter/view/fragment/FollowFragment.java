package com.erzu.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.RecommendBannerBean;
import com.erzu.quarter.model.bean.RecommendVideoBean;
import com.erzu.quarter.presenter.RecommendPresenter;
import com.erzu.quarter.view.IView.IRecommendVeiw;
import com.erzu.quarter.view.adapter.RecommendAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by samsung on 2018/1/22.
 */

public class FollowFragment extends Fragment implements IRecommendVeiw {
    @BindView(R.id.reciclerVeiw)
    RecyclerView reciclerVeiw;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_follow, null);
        unbinder = ButterKnife.bind(this, view);
        RecommendPresenter presenter=new RecommendPresenter(this);
        presenter.showVideo();
        return view;
    }

    @Override
    public void onSuccess(RecommendBannerBean recommendBannerBean) {

    }

    @Override
    public void onFailure(Exception e) {

    }

    @Override
    public void Success_video(RecommendVideoBean recommendVideoBean) {
        List<RecommendVideoBean.DataBean> data = recommendVideoBean.getData();
        reciclerVeiw.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecommendAdapter recyclerView_adapter = new RecommendAdapter(getActivity(), data);
        reciclerVeiw.setAdapter(recyclerView_adapter);
    }

    @Override
    public void Failure(Exception e) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
