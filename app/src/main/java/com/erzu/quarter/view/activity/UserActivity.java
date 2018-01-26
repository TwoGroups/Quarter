package com.erzu.quarter.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.EventBean;
import com.erzu.quarter.model.bean.RecommendBannerBean;
import com.erzu.quarter.model.bean.RecommendVideoBean;
import com.erzu.quarter.presenter.RecommendPresenter;
import com.erzu.quarter.view.IView.IRecommendVeiw;
import com.erzu.quarter.view.adapter.RecommendAdapter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserActivity extends AppCompatActivity implements IRecommendVeiw {

    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.works_rec)
    RecyclerView worksRec;
    @BindView(R.id.head_sdv)
    SimpleDraweeView headSdv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        RecommendPresenter presenter = new RecommendPresenter(this);
        presenter.showVideo();
        EventBus.getDefault().register(this);
    }

    @Subscribe(sticky = true)
    public void event(EventBean eventBean) {
        String cover = eventBean.getCover();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(cover)
                .setAutoPlayAnimations(true)
                .build();
        headSdv.setController(controller);
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
        worksRec.setLayoutManager(new LinearLayoutManager(this));
        RecommendAdapter recyclerView_adapter = new RecommendAdapter(UserActivity.this, data);
        worksRec.setAdapter(recyclerView_adapter);
    }

    @Override
    public void Failure(Exception e) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
