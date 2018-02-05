package com.erzu.quarter.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.CollectBean;
import com.erzu.quarter.presenter.CollectPresenter;
import com.erzu.quarter.utils.SharedPrefsUtil;
import com.erzu.quarter.view.IView.ICollectView;
import com.erzu.quarter.view.adapter.CollectAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectActivity extends AppCompatActivity implements ICollectView {

    @BindView(R.id.collect_back)
    LinearLayout collectBack;
    @BindView(R.id.collect_delete)
    TextView collectDelete;
    @BindView(R.id.collect_recyclerview)
    RecyclerView collectRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Integer uid = SharedPrefsUtil.getValue(this, "Account", "uid", 2868);
        String token = SharedPrefsUtil.getValue(this, "Account", "token", "4DBFB1AFEE4D3FB13325C051A227CF1F");
        setContentView(R.layout.activity_collect);
        ButterKnife.bind(this);
        CollectPresenter collectPresenter = new CollectPresenter(this);
        collectPresenter.CollectGetData(uid, token);
        collectRecyclerview.setLayoutManager(new LinearLayoutManager(this));

    }

    @OnClick({R.id.collect_back, R.id.collect_delete})
    public void onViewClicked(View view) {


        switch (view.getId()) {
            case R.id.collect_back:
                finish();
                break;
            case R.id.collect_delete:
                break;
        }
    }

    @Override
    public void onSucceed(CollectBean collectBean) {
        CollectAdapter collectAdapter = new CollectAdapter(this, collectBean);
        collectRecyclerview.setAdapter(collectAdapter);
    }

    @Override
    public void onFailure(Exception e) {

    }
}
