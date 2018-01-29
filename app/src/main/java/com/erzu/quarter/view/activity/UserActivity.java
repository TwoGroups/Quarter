package com.erzu.quarter.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class UserActivity extends AppCompatActivity implements IRecommendVeiw {

    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.works_rec)
    RecyclerView worksRec;
    @BindView(R.id.head_sdv)
    SimpleDraweeView headSdv;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.share)
    ImageView share;
    private String name;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        RecommendPresenter presenter = new RecommendPresenter(this);
        presenter.showVideo();
        EventBus.getDefault().register(this);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareMob();
            }
        });
    }

    private void ShareMob() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("https://user.qzone.qq.com");
        // text是分享文本，所有平台都需要这个字段
        oks.setText(name);
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(url);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(this);

    }

    @Subscribe(sticky = true)
    public void event(EventBean eventBean) {
        String cover = eventBean.getCover();
        name = eventBean.getName();
        url = eventBean.getUrl();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(cover)
                .setAutoPlayAnimations(true)
                .build();
        headSdv.setController(controller);
        textView.setText(name);
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
