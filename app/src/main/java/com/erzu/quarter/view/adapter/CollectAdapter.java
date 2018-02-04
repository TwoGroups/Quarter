package com.erzu.quarter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.CollectBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by hp on 2018/2/4.
 */

public class CollectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private CollectBean collectBean;


    public CollectAdapter(Context context, CollectBean collectBean) {
        this.context = context;
        this.collectBean = collectBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.collect_item, null);
        CollectViewHolder collectViewHolder = new CollectViewHolder(view);
        return collectViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CollectViewHolder) holder).mSimpleCollect.setImageURI(collectBean.getData().get(position).getCover());
        ((CollectViewHolder) holder).mNameCollect.setText(collectBean.getData().get(position).getUser().getNickname());
        ((CollectViewHolder) holder).mTitleNameCollect.setText(collectBean.getData().get(position).getUser().getNickname());


        ((CollectViewHolder) holder).mVideoplayerCollect.TOOL_BAR_EXIST = false;
        ((CollectViewHolder) holder).mVideoplayerCollect.setUp(collectBean.getData().get(position).getVideoUrl()
                , ((CollectViewHolder) holder).mVideoplayerCollect.SCREEN_LAYOUT_NORMAL, collectBean.getData().get(position).getPlayNum());
        Glide.with(context).load(collectBean.getData().get(position).getCover())
                .into(((CollectViewHolder) holder).mVideoplayerCollect.thumbImageView);
        ((CollectViewHolder) holder).mVideoplayerCollect.widthRatio = 4;//播放比例
        ((CollectViewHolder) holder).mVideoplayerCollect.heightRatio = 3;
    }

    @Override
    public int getItemCount() {
        return collectBean.getData() == null ? 0 : collectBean.getData().size();
    }

    public static class CollectViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView mSimpleCollect;
        private TextView mNameCollect;
        private TextView mTimerCollect;
        private SimpleDraweeView mYuanCollect;
        private TextView mTitleNameCollect;
        private JCVideoPlayerStandard mVideoplayerCollect;
        private RadioButton mBtn1;
        private RadioButton mBtn2;
        private RadioButton mBtn3;
        private RadioButton mBtn4;
        private RadioGroup mRgCollect;
        private TextView mCommentA;
        private TextView mCommentB;

        public CollectViewHolder(View itemView) {
            super(itemView);
            mSimpleCollect = (SimpleDraweeView) itemView.findViewById(R.id.collect_simple);
            mNameCollect = (TextView) itemView.findViewById(R.id.collect_name);
            mTimerCollect = (TextView) itemView.findViewById(R.id.collect_timer);
            mYuanCollect = (SimpleDraweeView) itemView.findViewById(R.id.collect_yuan);
            mTitleNameCollect = (TextView) itemView.findViewById(R.id.collect_title_name);
            mVideoplayerCollect = (JCVideoPlayerStandard) itemView.findViewById(R.id.collect_videoplayer);
            mBtn1 = (RadioButton) itemView.findViewById(R.id.btn1);
            mBtn2 = (RadioButton) itemView.findViewById(R.id.btn2);
            mBtn3 = (RadioButton) itemView.findViewById(R.id.btn3);
            mBtn4 = (RadioButton) itemView.findViewById(R.id.btn4);
            mRgCollect = (RadioGroup) itemView.findViewById(R.id.collect_rg);
            mCommentA = (TextView) itemView.findViewById(R.id.commentA);
            mCommentB = (TextView) itemView.findViewById(R.id.commentB);
        }
    }
}
