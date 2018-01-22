package com.erzu.quarter.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.erzu.quarter.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创作页面
 */
public class CreationActivity extends AppCompatActivity {

    @BindView(R.id.creation_fh)
    TextView creationFh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);
        ButterKnife.bind(this);
        //隐藏标题栏
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    @OnClick(R.id.creation_fh)
    public void onViewClicked() {
        //点击取消按钮销毁页面
        finish();
    }
}
