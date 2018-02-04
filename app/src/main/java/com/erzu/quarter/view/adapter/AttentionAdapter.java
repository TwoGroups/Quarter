package com.erzu.quarter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.AttentionBean;
import com.erzu.quarter.view.activity.AttentionActivity;

import java.util.List;

/**
 * Created by 超Sir on 2018/2/3.
 */

public class AttentionAdapter extends RecyclerView.Adapter<AttentionAdapter.MyViewHodler> {
    private Context context;
    private AttentionBean attentionBean;

    public AttentionAdapter(Context context, AttentionBean attentionBean) {
        this.context = context;
        this.attentionBean = attentionBean;
    }

    @Override
    public AttentionAdapter.MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.attention_item, null);
        MyViewHodler hodler = new MyViewHodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(AttentionAdapter.MyViewHodler holder, int position) {
        holder.attention_name.setText(attentionBean.getData().get(position).getUsername());
        holder.attention_time.setText(attentionBean.getData().get(position).getCreatetime());
    }

    @Override
    public int getItemCount() {
        return attentionBean.getData() == null ? 0 : attentionBean.getData().size();
    }


    class MyViewHodler extends RecyclerView.ViewHolder {
        private TextView attention_name;
        private TextView attention_time;

        public MyViewHodler(View itemView) {
            super(itemView);
            attention_name = itemView.findViewById(R.id.attention_name);
            attention_time = itemView.findViewById(R.id.attention_time);
        }
    }


}
