package com.erzu.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erzu.quarter.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 趣图页面
 * Created by hp on 2018/1/19.
 */
public class OddphotosFragment extends Fragment {
    private SimpleDraweeView mUserIamgeQutu;
    private SimpleDraweeView mMesgIamgeQutu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_oddphotos, null);
        mUserIamgeQutu = (SimpleDraweeView) view.findViewById(R.id.qutu_user_iamge);
        mMesgIamgeQutu = (SimpleDraweeView) view.findViewById(R.id.qutu_mesg_iamge);

        mUserIamgeQutu.setImageURI("http://tupian.qqjay.com/u/2013/1127/19_222949_14.jpg");
        mMesgIamgeQutu.setImageURI("http://tupian.qqjay.com/u/2013/1127/19_222949_3.jpg");
        return view;
    }




}
