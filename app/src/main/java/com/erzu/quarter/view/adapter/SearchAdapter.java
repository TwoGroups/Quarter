package com.erzu.quarter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.SearchBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHodler> {
    private Context context;
    private List<SearchBean.DataBean> list;
//    private View view;


    public SearchAdapter(Context context) {
        this.context = context;

    }

    public void addData(List<SearchBean.DataBean> dataBeans) {
        if(list==null){
            this.list = new ArrayList<>();
            list.addAll(dataBeans);
            notifyDataSetChanged();
        }

    }
    public void  clear(){
        if (list!=null){
            list.clear();
            notifyDataSetChanged();
        }

    }
    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=View.inflate(context,R.layout.search_item,null);
        return new MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(MyViewHodler holder, final int position) {

        String nickname = list.get(position).getNickname();
        Log.e(TAG, "数据"+nickname);
        holder.search_title.setText(nickname);
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
        private TextView search_title;
        private TextView mDelSearch;
        public MyViewHodler(View itemView) {
            super(itemView);
            mSimpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.simpleDraweeView);
            search_title=itemView.findViewById(R.id.search_title);
            mDelSearch = (TextView) itemView.findViewById(R.id.search_del);

        }
    }
}