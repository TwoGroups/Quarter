package com.erzu.quarter.view.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.RecommendVideoBean;
import com.erzu.quarter.model.bean.VideoRecommendBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by lenovo on 2018/1/23.
 */

public class OddphotosAdapter extends RecyclerView.Adapter<OddphotosAdapter.MyHodler> {
    List<RecommendVideoBean.DataBean> list;
    Context context;

    private View view;


    public OddphotosAdapter(Context context, List<RecommendVideoBean.DataBean> data) {
        this.context = context;
        this.list = data;
    }





    @Override
    public MyHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.oddphotos_item, null);
        MyHodler myHodler = new MyHodler(view);
        return myHodler;
    }

    @Override
    public void onBindViewHolder(MyHodler holder, final int position) {


        holder.mTitleText.setText(list.get(position).getUser().getNickname());
        holder.mTimeText.setText(list.get(position).getCreateTime());
        holder.mText01Qutu.setText(list.get(position).getWorkDesc());
        holder.mText02Qutu.setText(list.get(position).getWorkDesc());
//        holder.mTextQutu.setText(list.get(position).getComments().get(position).getContent());
        holder.mBtn4.setOnClickListener(new View.OnClickListener() {
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
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyHodler extends RecyclerView.ViewHolder {
        private SimpleDraweeView yuan;
        private SimpleDraweeView mUserIamgeQutu;
        private TextView mTitleText;
        private TextView mTimeText;
        private TextView mTextQutu;
        private ImageView mMesgIamgeQutu;
        private RadioButton mBtn2;
        private RadioButton mBtn3;
        private RadioButton mBtn4;
        private RadioButton mBtn5;
        private TextView mText01Qutu;
        private TextView mText02Qutu;
        public MyHodler(View itemView) {
            super(itemView);
            mUserIamgeQutu = (SimpleDraweeView) itemView.findViewById(R.id.qutu_user_iamge);
            mTitleText = (TextView) itemView.findViewById(R.id.text_title);
            mTimeText = (TextView) itemView.findViewById(R.id.text_time);
            mTextQutu = (TextView) itemView.findViewById(R.id.qutu_text);
            mMesgIamgeQutu = (ImageView) itemView.findViewById(R.id.qutu_mesg_iamge);
            mBtn2 = (RadioButton) itemView.findViewById(R.id.btn2);
            mBtn3 = (RadioButton) itemView.findViewById(R.id.btn3);
            mBtn4 = (RadioButton) itemView.findViewById(R.id.btn4);
            mBtn5 = (RadioButton) itemView.findViewById(R.id.btn5);
            mText01Qutu = (TextView) itemView.findViewById(R.id.qutu_text01);
            mText02Qutu = (TextView) itemView.findViewById(R.id.qutu_text02);
        }
    }
}
