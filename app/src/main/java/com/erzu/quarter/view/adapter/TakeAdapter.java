package com.erzu.quarter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.view.activity.TakeActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by samsung on 2018/2/3.
 */

public class TakeAdapter extends RecyclerView.Adapter<TakeAdapter.MyHolder> {
    Context context;
    private List<String> mDatas;
    List<String> textlist;

    public TakeAdapter(Context context, List<String> mDatas, List<String> textList) {
        this.context = context;
        this.mDatas = mDatas;
        this.textlist = textList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.take_adapter, null);
        MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
          DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(mDatas.get(position))
                .setAutoPlayAnimations(true)
                .build();
       holder.id_index_gallery_item_image.setController(controller);
        holder.id_index_gallery_item_text.setText(textlist.get(position));
    }

    @Override
    public int getItemCount() {
        return textlist==null?0:textlist.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView id_index_gallery_item_image;
        private final TextView id_index_gallery_item_text;

        public MyHolder(View itemView) {
            super(itemView);
            id_index_gallery_item_image = (SimpleDraweeView) itemView.findViewById(R.id.id_index_gallery_item_image);
            id_index_gallery_item_text = (TextView) itemView.findViewById(R.id.id_index_gallery_item_text);
        }
    }
}
