package com.erzu.quarter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.erzu.quarter.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by lenovo on 2018/2/3.
 */

public class LocalworkAdapter extends RecyclerView.Adapter<LocalworkAdapter.ViewHoleder> {

    Context context;


    public LocalworkAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHoleder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_localwork_item, null);
        return new ViewHoleder(view);
    }


    @Override
    public void onBindViewHolder(ViewHoleder holder, int position) {
//        holder.mAImage.setImageURI("http://img02.tooopen.com/images/20141229/sl_107003776898.jpg");
//        holder.mBImage.setImageURI("http://img06.tooopen.com/images/20180201/tooopen_sl_233434765325.jpg");
//        holder.mCImage.setImageURI("http://img06.tooopen.com/images/20170106/tooopen_sl_195866328575.jpg");
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHoleder extends RecyclerView.ViewHolder {
//        private SimpleDraweeView mAImage;
//        private SimpleDraweeView mBImage;
//        private SimpleDraweeView mCImage;
        public ViewHoleder(View itemView) {
            super(itemView);
//            mAImage = (SimpleDraweeView) itemView.findViewById(R.id.image_a);
//            mBImage = (SimpleDraweeView) itemView.findViewById(R.id.image_b);
//            mCImage = (SimpleDraweeView) itemView.findViewById(R.id.image_c);

        }
    }
}
