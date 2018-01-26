package com.erzu.quarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.erzu.quarter.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login_back)
    ImageView loginBack;
    @BindView(R.id.we_chat_login)
    ImageView weChatLogin;
    @BindView(R.id.qq_login)
    ImageView qqLogin;
    @BindView(R.id.other_login)
    TextView otherLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_back, R.id.we_chat_login, R.id.qq_login, R.id.other_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_back:
                finish();
                break;
            case R.id.we_chat_login:
                Toast.makeText(this, "暂不支持", Toast.LENGTH_SHORT).show();
                break;
            case R.id.qq_login:
                Toast.makeText(this, "暂不支持", Toast.LENGTH_SHORT).show();
                break;
            case R.id.other_login:
                Intent intent = new Intent(LoginActivity.this, ActivityLogin.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void finish() {
        super.finish();
        //系统自带动画--从左向右滑动的效果
//        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        //系统自带动画--从右向左滑动的效果
        overridePendingTransition(android.R.anim.slide_out_right,android.R.anim.slide_in_left);
    }

}
