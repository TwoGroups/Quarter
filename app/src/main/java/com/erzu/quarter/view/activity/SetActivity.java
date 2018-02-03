package com.erzu.quarter.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.utils.SharedPrefsUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetActivity extends AppCompatActivity {

    @BindView(R.id.message_back)
    LinearLayout messageBack;
    @BindView(R.id.vision_num)
    ImageView visionNum;
    @BindView(R.id.huancun)
    ImageView huancun;
    @BindView(R.id.edit_login)
    TextView editLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.edit_login)
    public void onViewClicked() {
        SharedPrefsUtil.putValue(this, "Account", "phone", "");
        SharedPrefsUtil.putValue(this, "Account", "password", "");
        SharedPrefsUtil.putValue(this, "Account", "token", "");
        SharedPrefsUtil.putValue(this, "Account", "nickName", "");
        SharedPrefsUtil.putValue(this, "Account", "uid", "");
        finish();
    }
}
