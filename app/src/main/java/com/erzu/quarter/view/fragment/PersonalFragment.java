package com.erzu.quarter.view.fragment;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.erzu.quarter.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * messageactivity 私信页面
 * Created by hp on 2018/1/23.
 */

public class PersonalFragment extends Fragment{
    View view;
    SimpleDraweeView personal_simple;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Fresco.initialize(getActivity());
        view = View.inflate(getActivity(), R.layout.fragment_personal, null);
        personal_simple = view.findViewById(R.id.personal_simple);
        PipelineDraweeController controller =
                (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                        .setUri(Uri.parse("res://"+getActivity().getPackageName()+"/"+R.mipmap.running))
                        .setAutoPlayAnimations(true) //自动播放gif动画
                        .build();
        //设置Controller
        personal_simple.setController(controller);
        return view;
    }
}
