package com.erzu.quarter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.view.activity.PutondisplayActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by samsung on 2018/2/4.
 */

public class PutondisolayAdapter extends RecyclerView.Adapter<PutondisolayAdapter.MyHolder> {
    Context context;
    List<String> putlist;
    List<String> textList;
    public PutondisolayAdapter(Context context, List<String> putlist,List<String> textList) {
        this.context=context;
        this.putlist=putlist;
        this.textList=textList;

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
                    .setUri(putlist.get(position))
                    .setAutoPlayAnimations(true)
                    .build();
            holder.simpleDraweeView.setController(controller);
            holder.textView.setText(textList.get(position));

    }

    @Override
    public int getItemCount() {
        return putlist == null ? 0 : putlist.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simpleDraweeView;
        private final TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.id_index_gallery_item_text);
            simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.id_index_gallery_item_image);
        }
    }
}
