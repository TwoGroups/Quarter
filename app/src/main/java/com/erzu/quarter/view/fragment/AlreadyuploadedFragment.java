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
import com.erzu.quarter.view.adapter.LocalworkAdapter;

/**
 * Created by lenovo on 2018/2/3.
 */

public class AlreadyuploadedFragment extends Fragment {
    private RecyclerView maleadyload_recyclerview;
    private LocalworkAdapter localworkAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.alreadyuploaded_item,null);

        maleadyload_recyclerview = (RecyclerView) view.findViewById(R.id.aleadyload_recyclerview);

        maleadyload_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        localworkAdapter = new LocalworkAdapter(getActivity());
        maleadyload_recyclerview.setAdapter(localworkAdapter);
        return view;
    }
}
