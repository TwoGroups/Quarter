package com.erzu.quarter.view.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.JokesBean;
import com.erzu.quarter.view.activity.UserActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 超Sir on 2018/1/22.
 */

public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.MyViewHodler>{
    private Context context;
    private List<JokesBean.DataBean> list;
    private static List<ImageView> imageViews = new ArrayList<>();
    private static List<TextView> textViews = new ArrayList<>();
    private boolean isMenuOpen = false;

    public JokesAdapter(Context context, List<JokesBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public JokesAdapter.MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {

//        View view = LayoutInflater.from(context).inflate(R.layout.jokes_item, parent, false);
        View view = View.inflate(context, R.layout.jokes_item, null);
        MyViewHodler hodler = new MyViewHodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(final JokesAdapter.MyViewHodler holder, int position) {
        holder.jokes_name.setText(list.get(position).getUser().getNickname());
        holder.jokes_time.setText(list.get(position).getCreateTime());
        holder.jokes_content.setText(list.get(position).getContent());

        holder.jokes_pic.setOnClickListener(new View.OnClickListener() {
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

    class MyViewHodler extends RecyclerView.ViewHolder {
        private SimpleDraweeView jokes_pic;
        private TextView jokes_name;
        private TextView jokes_time;
        private TextView jokes_content;


        public MyViewHodler(View itemView) {
            super(itemView);

            jokes_pic = itemView.findViewById(R.id.jokes_pic);
            jokes_name = itemView.findViewById(R.id.jokes_name);
            jokes_time = itemView.findViewById(R.id.jokes_time);
            jokes_content = itemView.findViewById(R.id.jokes_content);



        }
    }


}
