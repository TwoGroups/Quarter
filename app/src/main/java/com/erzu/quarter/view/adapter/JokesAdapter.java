package com.erzu.quarter.view.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.JokesBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 超Sir on 2018/1/22.
 */

public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.MyViewHodler> implements View.OnClickListener {
    private Context context;
    private List<JokesBean.DataBean> list;
    private static List<ImageView> imageViews = new ArrayList<>();
    private static List<TextView> textViews = new ArrayList<>();
    private boolean isMenuOpen = false;
    public JokesAdapter(Context context, List<JokesBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public JokesAdapter.MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {

//        View view = LayoutInflater.from(context).inflate(R.layout.jokes_item, parent, false);
        View view = View.inflate(context, R.layout.jokes_item, null);
        MyViewHodler hodler = new MyViewHodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(final JokesAdapter.MyViewHodler holder, int position) {
        holder.jokes_name.setText(list.get(position).getUser().getNickname());
        holder.jokes_time.setText(list.get(position).getCreateTime());
        holder.jokes_content.setText(list.get(position).getContent());
        MyViewHodler.imgPublish.setOnClickListener(this);

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_publish:
                if (!isMenuOpen) {
                    showOpenAnim(160);
                    MyViewHodler.imgPublish.setImageResource(R.mipmap.jia);
                }else {
                    showCloseAnim(160);
                    MyViewHodler.imgPublish.setImageResource(R.mipmap.jian);
                }
                break;
            case R.id.timg:
                Toast.makeText(context,"点击了1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.warning:
                Toast.makeText(context,"点击了2",Toast.LENGTH_SHORT).show();

                break;
            case R.id.banned:
                Toast.makeText(context,"点击了3",Toast.LENGTH_SHORT).show();

                break;
        }
    }
    //打开
    private void showOpenAnim(int dp) {
        MyViewHodler.timg.setVisibility(View.VISIBLE);
        MyViewHodler.banned.setVisibility(View.VISIBLE);
        MyViewHodler.warning.setVisibility(View.VISIBLE);
        MyViewHodler.tvTimg.setVisibility(View.VISIBLE);
        MyViewHodler.tvBanned.setVisibility(View.VISIBLE);
        MyViewHodler.tvWarning.setVisibility(View.VISIBLE);
        //for循环来开始小图标的出现动画
        for (int i = 0; i < imageViews.size(); i++) {
            textViews.get(i).setOnClickListener(this);
            AnimatorSet set = new AnimatorSet();
            double a = -(25 * Math.PI / 180 * (i + 1));
            double x = a * dip2px(dp);
            Log.e("aaaaa", x+"");
            //Log.e("aaa",a+"");
            // double y = b * dip2px(dp);
            //ObjectAnimator.ofFloat(textViews.get(i), "translationY", (float) (y * 0.25), (float) y),
            set.playTogether(
                    ObjectAnimator.ofFloat(imageViews.get(i), "translationX", (float) (x * 0.25), (float) x),
                    ObjectAnimator.ofFloat(imageViews.get(i), "rotation", 360, 0).setDuration(1000),
                    ObjectAnimator.ofFloat(imageViews.get(i), "alpha", 0, 1).setDuration(1000),
                    ObjectAnimator.ofFloat(textViews.get(i), "translationX", (float) (x * 0.25), (float) x),
                    ObjectAnimator.ofFloat(textViews.get(i), "alpha", 0, 1).setDuration(1000)
            );
            //this is 弹弹弹
            //set.setInterpolator(new BounceInterpolator());
            set.setDuration(1000);
            set.start();

            set.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    //菜单状态置打开
                    isMenuOpen = true;
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }

        //转动加号大图标本身
        ObjectAnimator rotate = ObjectAnimator.ofFloat(MyViewHodler.imgPublish, "rotation", 360, 0).setDuration(1000);
        //this is 弹弹弹
        //rotate.setInterpolator(new BounceInterpolator());
        rotate.start();

    }
    //关闭
    private void showCloseAnim(int dp) {
        for (int i = 0; i < imageViews.size(); i++) {
            AnimatorSet set = new AnimatorSet();
            double a = -(25 * Math.PI / 180 * (i + 1));
            //double b = -Math.sin(20 * Math.PI / 180 * (i * 2 + 1));
            double x = a * dip2px(dp);

            //double y = b * dip2px(dp);
            //ObjectAnimator.ofFloat(textViews.get(i), "translationY", (float) y, (float) (y * 0.25)),
            set.playTogether(
                    ObjectAnimator.ofFloat(imageViews.get(i), "translationX", (float) x, (float) (x * 0.25)),
                    ObjectAnimator.ofFloat(imageViews.get(i), "rotation", 0, 360).setDuration(1000),
                    ObjectAnimator.ofFloat(imageViews.get(i), "alpha", 1, 0).setDuration(1000),
                    ObjectAnimator.ofFloat(textViews.get(i), "translationX", (float) x, (float) (x * 0.25)),
                    ObjectAnimator.ofFloat(textViews.get(i), "alpha", 1, 0).setDuration(1000)
            );
            //this is 弹弹弹
            //set.setInterpolator(new AccelerateInterpolator());
            set.setDuration(1000);
            set.start();

            set.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    MyViewHodler.timg.setVisibility(View.GONE);
                    MyViewHodler.banned.setVisibility(View.GONE);
                    MyViewHodler.warning.setVisibility(View.GONE);
                    MyViewHodler.tvTimg.setVisibility(View.GONE);
                    MyViewHodler.tvBanned.setVisibility(View.GONE);
                    MyViewHodler.tvWarning.setVisibility(View.GONE);
                    //菜单状态置关闭
                    isMenuOpen = false;
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }
                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }
        //转动加号大图标本身
        ObjectAnimator rotate = ObjectAnimator.ofFloat(MyViewHodler.imgPublish, "rotation", 0, 360).setDuration(1000);
        //this is 弹弹弹
        //rotate.setInterpolator(new BounceInterpolator());
        rotate.start();
    }
    //转换dp参数为px值
    private int dip2px(int value) {
        float density = context.getResources()
                .getDisplayMetrics().density;
        return (int) (density * value + 0.5f);
    }
   static class MyViewHodler extends RecyclerView.ViewHolder {
        private SimpleDraweeView jokes_pic;
        private TextView jokes_name;
        private TextView jokes_time;
        private TextView jokes_content;
//        private ImageView jokes_jia;
//        private ImageView jokes_dx;
//        private ImageView jokes_fx;
//        private ImageView jokes_xx;
       static ImageView timg;
       static ImageView warning;
       static ImageView banned;
       static TextView tvTimg;
       static TextView tvWarning;
       static TextView tvBanned;
       static ImageView imgPublish;
        public MyViewHodler(View itemView) {
            super(itemView);

            jokes_pic = itemView.findViewById(R.id.jokes_pic);
            jokes_name = itemView.findViewById(R.id.jokes_name);
            jokes_time = itemView.findViewById(R.id.jokes_time);
            jokes_content = itemView.findViewById(R.id.jokes_content);
//            jokes_jia = itemView.findViewById(R.id.jokes_jia);
//            jokes_dx = itemView.findViewById(R.id.jokes_dx);
//            jokes_fx = itemView.findViewById(R.id.jokes_fx);
//            jokes_xx = itemView.findViewById(R.id.jokes_xx);
            timg = itemView.findViewById(R.id.timg);
            warning = itemView.findViewById(R.id.warning);
            banned = itemView.findViewById(R.id.banned);
            tvBanned = itemView.findViewById(R.id.tv_banned);
            tvTimg = itemView.findViewById(R.id.tv_timg);
            tvWarning = itemView.findViewById(R.id.tv_warning);
            imgPublish = itemView.findViewById(R.id.img_publish);
            imageViews.add(banned);
            imageViews.add(timg);
            imageViews.add(warning);
            textViews.add(tvBanned);
            textViews.add(tvTimg);
            textViews.add(tvWarning);

        }
    }


}
