package com.erzu.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erzu.quarter.R;
import com.erzu.quarter.view.adapter.MessageFragmentAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * messageactivity 消息页面
 * Created by hp on 2018/1/23.
 */

public class MessageFragment extends Fragment {
    @BindView(R.id.message_recyclerview)
    RecyclerView messageRecyclerview;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_message, null);
        unbinder = ButterKnife.bind(this, view);
        messageRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        MessageFragmentAdapter adapter = new MessageFragmentAdapter(getActivity());
        messageRecyclerview.setAdapter(adapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
