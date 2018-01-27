package com.erzu.quarter.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.RecommendBannerBean;
import com.erzu.quarter.model.bean.RecommendVideoBean;
import com.erzu.quarter.presenter.RecommendPresenter;
import com.erzu.quarter.view.IView.IRecommendVeiw;
import com.erzu.quarter.view.adapter.RecommendAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectActivity extends AppCompatActivity implements IRecommendVeiw{

    @BindView(R.id.collect_back)
    LinearLayout collectBack;
    @BindView(R.id.collect_delete)
    TextView collectDelete;
    @BindView(R.id.collect_recyclerview)
    RecyclerView collectRecyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        ButterKnife.bind(this);
        RecommendPresenter presenter=new RecommendPresenter(this);
        presenter.showVideo();
    }

    @OnClick({R.id.collect_back, R.id.collect_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.collect_back:
                //点击返回按钮销毁页面
                finish();
                break;
            case R.id.collect_delete:
                //点击删除按钮
                break;
        }
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
        collectRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        RecommendAdapter recyclerView_adapter = new RecommendAdapter(CollectActivity.this, data);
        collectRecyclerview.setAdapter(recyclerView_adapter);
    }

    @Override
    public void Failure(Exception e) {

    }
}
