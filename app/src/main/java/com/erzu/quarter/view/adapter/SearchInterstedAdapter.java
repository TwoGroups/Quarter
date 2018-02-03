package com.erzu.quarter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.SearchBean;
import com.erzu.quarter.model.bean.SearchInterstedBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 *
 */

public class SearchInterstedAdapter extends RecyclerView.Adapter<SearchInterstedAdapter.MyViewHodler> {
    private Context context;
    private List<SearchInterstedBean.DataBean> list;
    private View view;

//    private View view;


    public SearchInterstedAdapter(Context context) {
        this.context = context;

    }

    public void addData(List<SearchInterstedBean.DataBean> dataBeans) {
        if (list == null) {
            this.list = new ArrayList<>();
            list.addAll(dataBeans);
            notifyDataSetChanged();
        }

    }

    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {

        view = View.inflate(context, R.layout.search_intersted_item, null);
        return new MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(MyViewHodler holder, int position) {

      holder.mSearch_msg.setText(list.get(position).getUsername());
      holder.mSearch_title.setText(list.get(position).getUsername());
      holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(context, "关注", Toast.LENGTH_SHORT).show();
          }
      });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class MyViewHodler extends RecyclerView.ViewHolder {
        private SimpleDraweeView mSimpleDraweeView;
        private TextView mSearch_title;
        private TextView mSearch_msg;
        private LinearLayout mLinearLayout;
        public MyViewHodler(View itemView) {
            super(itemView);
            mSimpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.simpleDraweeView);
            mSearch_title = (TextView) itemView.findViewById(R.id.search_title);
            mSearch_msg = (TextView) itemView.findViewById(R.id.search_mesg);
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}