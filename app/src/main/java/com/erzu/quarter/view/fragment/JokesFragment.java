package com.erzu.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.JokesBean;
import com.erzu.quarter.presenter.JokesPresenter;
import com.erzu.quarter.view.IView.IJokesView;
import com.erzu.quarter.view.adapter.JokesAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 段子页面
 * Created by hp on 2018/1/19.
 */

public class JokesFragment extends Fragment implements IJokesView {

    @BindView(R.id.jokes_rv)
    RecyclerView jokesRv;
    Unbinder unbinder;
    private List<JokesBean.DataBean> list;
    private JokesAdapter jokesAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_jokes, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//实例persenter
        JokesPresenter jokesPresenter = new JokesPresenter(this);
        jokesPresenter.getJokesData();

        jokesRv.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void Succeed(JokesBean jokesBean) {
        list = jokesBean.getData();
        jokesAdapter = new JokesAdapter(getActivity(), list);
        jokesRv.setAdapter(jokesAdapter);

    }

    @Override
    public void Failure(Exception e) {
        Log.e("JokesFragment", "Failure: " + "请求失败");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
