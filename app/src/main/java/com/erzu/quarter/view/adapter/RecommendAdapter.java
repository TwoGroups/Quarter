package com.erzu.quarter.view.adapter;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.RecommendVideoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by samsung on 2018/1/22.
 */

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.MyHolder> {

    List<RecommendVideoBean.DataBean> list;
    Context context;

    private View view;
    private  SimpleDraweeView yuan;
    public RecommendAdapter(Context context, List<RecommendVideoBean.DataBean> data) {
        this.context = context;
        this.list = data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.recommendrecyclerview_noe, null);
        MyHolder myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        holder.textView.setText(list.get(position).getWorkDesc());
        holder.timer.setText(list.get(position).getCreateTime());
        holder.yuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animator animator3 = AnimatorInflater.loadAnimator(context, R.animator.rotation);
                animator3.setTarget(holder.yuan);
                animator3.start();
                if (R.animator.rotation==500){

                    showPopwindow();
                }
            }

            private void showPopwindow() {



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

        public MyHolder(View itemView) {
            super(itemView);
            timer = (TextView) itemView.findViewById(R.id.timer);
            title = (TextView) itemView.findViewById(R.id.title_name);
            textView = (TextView) itemView.findViewById(R.id.title_name);
            commentA = (TextView) itemView.findViewById(R.id.commentA);
            commentB = (TextView) itemView.findViewById(R.id.commentB);
            yuan = (SimpleDraweeView)itemView.findViewById(R.id.yuan);
        }
    }
}
