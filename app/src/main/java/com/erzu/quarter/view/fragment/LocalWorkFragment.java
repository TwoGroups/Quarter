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

import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.*;

/**
 * Created by lenovo on 2018/2/3.
 */

public class LocalWorkFragment extends Fragment {
    private RecyclerView mRecyclerviewLocalwork;
    private LocalworkAdapter localworkAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.localwork_item, null);

        mRecyclerviewLocalwork = (RecyclerView) view.findViewById(R.id.localwork_recyclerview);

        mRecyclerviewLocalwork.setLayoutManager(new LinearLayoutManager(getActivity()));
        localworkAdapter = new LocalworkAdapter(getActivity());
        mRecyclerviewLocalwork.setAdapter(localworkAdapter);


        return view;
    }

}
