package com.erzu.quarter.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.erzu.quarter.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jzvd.JZVideoPlayerStandard;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class VideoDetailsActivity extends AppCompatActivity {

    @BindView(R.id.details_back)
    ImageView detailsBack;
    @BindView(R.id.btn_like)
    RadioButton btn2;
    @BindView(R.id.btn_dislike)
    RadioButton btn3;
    @BindView(R.id.btn_share)
    RadioButton btn4;
    @BindView(R.id.video_title)
    RelativeLayout videoTitle;
    @BindView(R.id.video_play)
    JZVideoPlayerStandard videoPlay;
    @BindView(R.id.video_comment)
    ListView videoComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_details);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.details_back, R.id.btn_like, R.id.btn_dislike, R.id.btn_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.details_back:
                break;
            case R.id.btn_like:
                break;
            case R.id.btn_dislike:
                break;
            case R.id.btn_share:
                ShareMob();
                break;
        }
    }
    private void ShareMob() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("Testing message");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");
        // 启动分享GUI
        oks.show(this);
    }
}
