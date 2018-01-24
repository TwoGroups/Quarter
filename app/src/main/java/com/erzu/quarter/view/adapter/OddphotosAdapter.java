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
    public void onBindViewHolder(MyHodler holder, int position) {


        holder.mTitleText.setText(list.get(position).getUser().getNickname());
        holder.mTimeText.setText(list.get(position).getCreateTime());
        holder.mText01Qutu.setText(list.get(position).getWorkDesc());
        holder.mText02Qutu.setText(list.get(position).getWorkDesc());
//        holder.mTextQutu.setText(list.get(position).getComments().get(position).getContent());
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
