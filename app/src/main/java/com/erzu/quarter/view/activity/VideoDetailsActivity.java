package com.erzu.quarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    RadioButton btnLike;
    @BindView(R.id.btn_dislike)
    RadioButton btnDislike;
    @BindView(R.id.btn_share)
    Button btnShare;
    @BindView(R.id.video_title)
    RelativeLayout videoTitle;
    @BindView(R.id.video_play)
    JZVideoPlayerStandard videoPlay;
    @BindView(R.id.text_null)
    TextView textNull;
    //    @BindView(R.id.video_comment)
    //    ListView videoComment;
    //    private List<String> list;
    //    private VideoCommentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_details);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        videoPlay.setUp(url, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "");
        String html = "拿起手机<font color='#03A9F4'>抢个沙发</font>吧!~";
        textNull.setText(Html.fromHtml(html));
        //        adapter = new VideoCommentAdapter(this, list);
        //        videoComment.setAdapter(adapter);
    }

    @OnClick({R.id.details_back, R.id.btn_like, R.id.btn_dislike, R.id.btn_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.details_back:
                finish();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * backPress函数判断了点击回退按钮的相应，
     * 如果全屏会退出全屏播放，如果不是全屏则会交给Activity
     */
    @Override
    public void onBackPressed() {
        if (JZVideoPlayerStandard.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    /**
     * 暂停 /失去焦点
     * Activity或者按Home键之后会视频就会releas(释放)
     */
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayerStandard.releaseAllVideos();
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
        oks.setText("WillianSun");//name
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://www.baidu.com");//url
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
