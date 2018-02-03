package com.erzu.quarter.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.erzu.quarter.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectActivity extends AppCompatActivity {

    @BindView(R.id.collect_back)
    LinearLayout collectBack;
    @BindView(R.id.collect_delete)
    TextView collectDelete;
    @BindView(R.id.collect_recyclerview)
    RecyclerView collectRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        ButterKnife.bind(this);

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
}
