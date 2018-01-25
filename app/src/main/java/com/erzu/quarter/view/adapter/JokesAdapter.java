package com.erzu.quarter.view.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.JokesBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 超Sir on 2018/1/22.
 */

public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.MyViewHodler> {
    private Context context;
    private List<JokesBean.DataBean> list;

    public JokesAdapter(Context context, List<JokesBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public JokesAdapter.MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LinearLayout.inflate(context, R.layout.jokes_item, null);
        MyViewHodler hodler = new MyViewHodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(final JokesAdapter.MyViewHodler holder, int position) {
        holder.jokes_name.setText(list.get(position).getUser().getNickname());
        holder.jokes_time.setText(list.get(position).getCreateTime());
        holder.jokes_content.setText(list.get(position).getContent());

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
        private ImageView jokes_jia;
        private ImageView jokes_dx;
        private ImageView jokes_fx;
        private ImageView jokes_xx;

        public MyViewHodler(View itemView) {
            super(itemView);

            jokes_pic = itemView.findViewById(R.id.jokes_pic);
            jokes_name = itemView.findViewById(R.id.jokes_name);
            jokes_time = itemView.findViewById(R.id.jokes_time);
            jokes_content = itemView.findViewById(R.id.jokes_content);
            jokes_jia = itemView.findViewById(R.id.jokes_jia);
            jokes_dx = itemView.findViewById(R.id.jokes_dx);
            jokes_fx = itemView.findViewById(R.id.jokes_fx);
            jokes_xx = itemView.findViewById(R.id.jokes_xx);

        }
    }


}
