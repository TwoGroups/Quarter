package com.erzu.quarter.view.adapter;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.EventBean;
import com.erzu.quarter.model.bean.RecommendVideoBean;
import com.erzu.quarter.utils.CustomPopWindow;
import com.erzu.quarter.view.activity.UserActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import cn.sharesdk.onekeyshare.OnekeyShare;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


/**
 * 推荐适配器
 */

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.MyHolder> {

    List<RecommendVideoBean.DataBean> list;
    Context context;


    private View view;
    private SimpleDraweeView yuan;
    private JCVideoPlayerStandard jcVideoPlayerStandard;

    public RecommendAdapter(Context context, List<RecommendVideoBean.DataBean> data) {
        this.context = context;
        this.list = data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.recommendrecyclerview_noe, null);
        jcVideoPlayerStandard = (JCVideoPlayerStandard) view.findViewById(R.id.videoplayer);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(list.get(position).getCover())
                .setAutoPlayAnimations(true)
                .build();
        holder.sdv.setController(controller);
        holder.textView.setText(list.get(position).getWorkDesc());
        holder.timer.setText(list.get(position).getCreateTime());
        holder.name.setText(list.get(position).getUser().getNickname());

        jcVideoPlayerStandard.TOOL_BAR_EXIST = false;
        jcVideoPlayerStandard.setUp(list.get(position).getVideoUrl()
                , jcVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, list.get(position).getPlayNum());
        Glide.with(context).load(list.get(position).getCover())
                .into(jcVideoPlayerStandard.thumbImageView);
        jcVideoPlayerStandard.widthRatio = 4;//播放比例
        jcVideoPlayerStandard.heightRatio = 3;





        holder.but_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              ShareMob();
            }


                private void ShareMob() {
                    OnekeyShare oks = new OnekeyShare();
                    //关闭sso授权
                    oks.disableSSOWhenAuthorize();
                    // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
                    oks.setTitle(list.get(position).getCover());
                    // titleUrl是标题的网络链接，QQ和QQ空间等使用
                    oks.setTitleUrl(list.get(position).getVideoUrl());
                    // text是分享文本，所有平台都需要这个字段
                    oks.setText(list.get(position).getCover());
                    // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                    //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
                    // url仅在微信（包括好友和朋友圈）中使用
                    oks.setUrl(list.get(position).getVideoUrl());
                    // comment是我对这条分享的评论，仅在人人网和QQ空间使用
                    oks.setComment(list.get(position).getCover());
                    // site是分享此内容的网站名称，仅在QQ空间使用
                    oks.setSite(context.getString(R.string.app_name));
                    // siteUrl是分享此内容的网站地址，仅在QQ空间使用
                    oks.setSiteUrl(list.get(position).getVideoUrl());

                    // 启动分享GUI
                    oks.show(context);

                }


        });

        holder.sdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().postSticky(new EventBean(list.get(position).getCover(),
                        list.get(position).getUser().getNickname(),
                        list.get(position).getVideoUrl()));
                context.startActivity(new Intent(context, UserActivity.class));
            }
        });

    }



    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView commentA;
        private final TextView commentB;
        private final TextView textView;
        private final TextView timer;
        private final SimpleDraweeView sdv;
        private final TextView name;
        private final RadioButton but_share;


        public MyHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            timer = (TextView) itemView.findViewById(R.id.timer);
            title = (TextView) itemView.findViewById(R.id.title_name);
            textView = (TextView) itemView.findViewById(R.id.title_name);
            commentA = (TextView) itemView.findViewById(R.id.commentA);
            commentB = (TextView) itemView.findViewById(R.id.commentB);
            sdv = (SimpleDraweeView) itemView.findViewById(R.id.sdv);
            but_share = (RadioButton)itemView.findViewById(R.id.btn3);

        }
    }

}
