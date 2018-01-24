package com.erzu.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erzu.quarter.ImagGithub.ImgGithub;
import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.RecommendBannerBean;
import com.erzu.quarter.model.bean.RecommendVideoBean;
import com.erzu.quarter.model.bean.VideoRecommendBean;
import com.erzu.quarter.model.httpfz.APIFactory;
import com.erzu.quarter.presenter.RecommendPresenter;
import com.erzu.quarter.view.IView.IRecommendVeiw;
import com.erzu.quarter.view.adapter.OddphotosAdapter;
import com.erzu.quarter.view.adapter.RecommendAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 趣图页面
 * Created by hp on 2018/1/19.
 */
public class OddphotosFragment extends Fragment implements IRecommendVeiw{

    private RecyclerView mRyvOddphotos;
    List<String> list_banner;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_oddphotos, null);

        mRyvOddphotos = (RecyclerView) view.findViewById(R.id.oddphotos_ryv);

        RecommendPresenter presenter=new RecommendPresenter(this);
        presenter.showRecomend();
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
        mRyvOddphotos.setLayoutManager(new LinearLayoutManager(getActivity()));
        OddphotosAdapter recyclerView_adapter = new OddphotosAdapter(getActivity(), data);
        mRyvOddphotos.setAdapter(recyclerView_adapter);

        }

    @Override
    public void Failure(Exception e) {

    }

}
