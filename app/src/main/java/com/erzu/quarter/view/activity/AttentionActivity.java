package com.erzu.quarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.AttentionBean;
import com.erzu.quarter.presenter.AttentionPresenter;
import com.erzu.quarter.utils.SharedPrefsUtil;
import com.erzu.quarter.view.IView.IMyAttentionView;
import com.erzu.quarter.view.adapter.AttentionAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的关注界面
 * 李永超
 */
public class AttentionActivity extends AppCompatActivity implements IMyAttentionView {

    @BindView(R.id.attention_fh)
    ImageView attentionFh;
    @BindView(R.id.attention_back)
    TextView attentionBack;
    @BindView(R.id.attention_hot)
    TextView attentionHot;
    @BindView(R.id.attention_rv)
    RecyclerView attentionRv;
    private AttentionPresenter attentionPresenter;
    private AttentionAdapter attentionAdapter;
    private List<AttentionBean.DataBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention);
        ButterKnife.bind(this);
        Integer uid = SharedPrefsUtil.getValue(this, "Account", "uid", 2686);
        String token = SharedPrefsUtil.getValue(this, "Account", "token", "4DBFB1AFEE4D3FB13325C051A227CF1F");



        attentionPresenter = new AttentionPresenter(this);
        attentionPresenter.getAttentionData(uid, token);

        attentionRv.setLayoutManager(new LinearLayoutManager(this));

    }

    @OnClick({R.id.attention_fh, R.id.attention_back, R.id.attention_hot})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.attention_fh:
                finish();
                break;
            case R.id.attention_back:
                finish();
                break;
            case R.id.attention_hot:
                startActivity(new Intent(this, HotAttentionActivity.class));
                break;
        }
    }

    @Override
    public void Succeed(AttentionBean attentionBean) {
//        data = attentionBean.getData();
        attentionAdapter = new AttentionAdapter(this, attentionBean);
        attentionRv.setAdapter(attentionAdapter);
    }

    @Override
    public void Failure(Exception e) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        attentionPresenter.detach();
    }
}
