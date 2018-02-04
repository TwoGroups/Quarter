package com.erzu.quarter.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.erzu.quarter.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HotAttentionActivity extends AppCompatActivity {

    @BindView(R.id.hotattention_qx)
    TextView hotattention_Qx;
    @BindView(R.id.hotattention_sousuo)
    EditText hotattention_Sousuo;
    @BindView(R.id.hotattention_tablayout)
    TabLayout hotattention_Tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotattention);
        ButterKnife.bind(this);

        hotattention_Tablayout.addTab(hotattention_Tablayout.newTab().setText("新闻"));
        hotattention_Tablayout.addTab(hotattention_Tablayout.newTab().setText("爆笑"));
        hotattention_Tablayout.addTab(hotattention_Tablayout.newTab().setText("励志"));
        hotattention_Tablayout.addTab(hotattention_Tablayout.newTab().setText("美食"));
        hotattention_Tablayout.addTab(hotattention_Tablayout.newTab().setText("网红"));
        hotattention_Tablayout.addTab(hotattention_Tablayout.newTab().setText("颜值"));



    }

    @OnClick(R.id.hotattention_qx)
    public void onViewClicked() {
        finish();
    }
}
