package com.erzu.quarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.erzu.quarter.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FindPasswordActivity extends AppCompatActivity {

    @BindView(R.id.alert_back)
    ImageView alertBack;
    @BindView(R.id.has_account)
    TextView hasAccount;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.alter_phone)
    EditText alterPhone;
    @BindView(R.id.alter_password)
    EditText alterPassword;
    @BindView(R.id.alter_btn)
    Button alterBtn;
    @BindView(R.id.visitor_login)
    TextView visitorLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.alert_back, R.id.has_account, R.id.alter_btn, R.id.visitor_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.alert_back:
                finish();
                break;
            case R.id.has_account:
                finish();
                break;
            case R.id.alter_btn:

                break;
            case R.id.visitor_login:
                Intent visitor = new Intent(FindPasswordActivity.this, MainActivity.class);
                startActivity(visitor);
                finish();
                break;
        }
    }
    @Override
    public void finish() {
        super.finish();
        //系统自带动画--从左向右滑动的效果
        //        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        //系统自带动画--从右向左滑动的效果
        overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
    }
}
