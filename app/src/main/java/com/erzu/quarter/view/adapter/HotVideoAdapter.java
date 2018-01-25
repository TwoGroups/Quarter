package com.erzu.quarter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.RecommendVideoBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by War on 2018/1/22.
 */

public class HotVideoAdapter extends RecyclerView.Adapter<HotVideoAdapter.MyViewHolder> {
    private Context context;
    private List<RecommendVideoBean.DataBean> list;

    public HotVideoAdapter(Context context, List<RecommendVideoBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.recom_rcy_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.videoPlayer.setUp(list.get(position).getVideoUrl(), JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "");
        ImageLoader.getInstance().displayImage(list.get(position).getCover(), holder.videoPlayer.thumbImageView);
        holder.videoItemTitle.setText(list.get(position).getCreateTime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //                new Intent()
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.videoplayer)
        JZVideoPlayerStandard videoPlayer;
        @BindView(R.id.video_item_title)
        TextView videoItemTitle;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
