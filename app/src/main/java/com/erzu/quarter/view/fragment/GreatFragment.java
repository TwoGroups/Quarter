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
import com.erzu.quarter.presenter.RecommendPresenter;
import com.erzu.quarter.view.IView.IRecommendVeiw;
import com.erzu.quarter.view.adapter.RecommendAdapter;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by samsung on 2018/1/22.
 */

public class GreatFragment extends Fragment implements IRecommendVeiw{
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.rec)
    RecyclerView rec;
    Unbinder unbinder;
    List<String> list_banner;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_great, null);
        unbinder = ButterKnife.bind(this, view);
        RecommendPresenter  presenter=new RecommendPresenter(this);
        presenter.showRecomend();
        presenter.showVideo();
        return view;
    }



    @Override
    public void onSuccess(RecommendBannerBean recommendBannerBean) {
        List<RecommendBannerBean.DataBean> data = recommendBannerBean.getData();
        list_banner = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            banner.setImageLoader(new ImgGithub());
            list_banner.add(data.get(i).getIcon());
            Log.i("******", "showData: " + list_banner);
            banner.setImages(list_banner);
            banner.start();

        }
    }

    @Override
    public void onFailure(Exception e) {

    }

    @Override
    public void Success_video(RecommendVideoBean recommendVideoBean) {
        List<RecommendVideoBean.DataBean> data = recommendVideoBean.getData();
        rec.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecommendAdapter recyclerView_adapter = new RecommendAdapter(getActivity(), data);
        rec.setAdapter(recyclerView_adapter);
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
