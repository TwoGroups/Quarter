package com.erzu.quarter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.SearchBean;
import com.erzu.quarter.model.bean.SearchHistoryBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */

public class SearchHistoryAdapter extends RecyclerView.Adapter<SearchHistoryAdapter.MyViewHodler> {
    private Context context;
    private List<SearchBean.DataBean> list;

    private View view;


    public SearchHistoryAdapter(Context context) {
        this.context = context;

    }
    public void  clear(){
        if (list!=null){
            list.clear();
        }
            notifyDataSetChanged();
    }
    public void addData(List<SearchBean.DataBean> dataBeans) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(dataBeans);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {

         view = View.inflate(context, R.layout.search_history_item, null);
        return new MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(MyViewHodler holder, final int position) {

         holder.mTitleSearch.setText(list.get(position).getNickname());
         holder.mDelSearch.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 list.remove(position);
                 notifyDataSetChanged();
             }
         });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyViewHodler extends RecyclerView.ViewHolder {
        private SimpleDraweeView mSimpleDraweeView;
        private TextView mTitleSearch;
        private TextView mDelSearch;
        public MyViewHodler(View itemView) {
            super(itemView);
            mSimpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.simpleDraweeView);
            mTitleSearch = (TextView) itemView.findViewById(R.id.search_title);
            mDelSearch = (TextView) itemView.findViewById(R.id.search_del);

        }
    }
}