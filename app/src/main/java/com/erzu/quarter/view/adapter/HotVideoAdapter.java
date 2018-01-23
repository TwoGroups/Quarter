package com.erzu.quarter.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.HotVideoBean;
import com.erzu.quarter.model.bean.VideoRecommendBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by War on 2018/1/22.
 */

public class HotVideoAdapter extends RecyclerView.Adapter<HotVideoAdapter.MyViewHolder> {
    private Context context;
    private List<HotVideoBean.DataBean> list;

    public HotVideoAdapter(Context context) {
        this.context = context;
    }

    public void addData(HotVideoBean bean) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list = bean.getData();
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.recom_rcy_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        holder.videoItemImg.setImageURI(Uri.parse(list.get(position).getCover()));
        holder.videoItemImg.setImageResource(R.mipmap.ic_launcher);
        holder.videoItemTitle.setText(list.get(position).getCreateTime());
    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.video_item_img)
        ImageView videoItemImg;
        @BindView(R.id.video_item_title)
        TextView videoItemTitle;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
