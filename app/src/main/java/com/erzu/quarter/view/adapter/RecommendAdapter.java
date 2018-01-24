package com.erzu.quarter.view.adapter;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.RecommendVideoBean;
import com.erzu.quarter.utils.CustomPopWindow;
import com.erzu.quarter.view.activity.UserActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


/**
 * 适配器
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
    public void onBindViewHolder(final MyHolder holder, int position) {

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




        holder.yuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animator animator3 = AnimatorInflater.loadAnimator(context, R.animator.rotation);
                animator3.setTarget(holder.yuan);
                animator3.start();

                showPopwindow();
            }

            private void showPopwindow() {
                View contentView = LayoutInflater.from(context).inflate(R.layout.popwindows, null);
//                //处理popWindow 显示内容
//                handleLogic(contentView);
                //创建并显示popWindow
                CustomPopWindow mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(context)
                        .setView(contentView)
                        .create()
                        .showAsDropDown(contentView, 500, 700);
            }
        });
        holder.sdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        private final SimpleDraweeView yuan;
        private final SimpleDraweeView sdv;
        private final TextView name;


        public MyHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            timer = (TextView) itemView.findViewById(R.id.timer);
            title = (TextView) itemView.findViewById(R.id.title_name);
            textView = (TextView) itemView.findViewById(R.id.title_name);
            commentA = (TextView) itemView.findViewById(R.id.commentA);
            commentB = (TextView) itemView.findViewById(R.id.commentB);
            yuan = (SimpleDraweeView) itemView.findViewById(R.id.yuan);
            sdv = (SimpleDraweeView) itemView.findViewById(R.id.sdv);

        }
    }

}
