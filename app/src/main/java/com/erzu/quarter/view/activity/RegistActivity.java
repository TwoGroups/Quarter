package com.erzu.quarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.RegistBean;
import com.erzu.quarter.presenter.RegistPresenter;
import com.erzu.quarter.view.IView.IRegistView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistActivity extends AppCompatActivity implements IRegistView {

    @BindView(R.id.regist_back)
    ImageView registBack;
    @BindView(R.id.has_account)
    TextView hasAccount;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.regist_phone)
    EditText registPhone;
    @BindView(R.id.regist_password)
    EditText registPassword;
    @BindView(R.id.regist_btn)
    Button registBtn;
    @BindView(R.id.visitor_login)
    TextView visitorLogin;
    private RegistPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);
        //隐藏标题栏
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        presenter = new RegistPresenter(this);
    }

    @OnClick({R.id.regist_back, R.id.has_account, R.id.regist_btn, R.id.visitor_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.regist_back:
                //返回
                finish();
                break;
            case R.id.has_account:
                finish();
                break;
            case R.id.regist_btn:
                if (TextUtils.isEmpty(registPhone.getText().toString()) || TextUtils.isEmpty(registPassword.getText().toString())) {
                    Toast.makeText(this, "账号和密码不能为空", Toast.LENGTH_SHORT).show();
                } else if (!isMobileNO(registPhone.getText().toString()) || registPassword.getText().toString().length() > 8) {
                    Toast.makeText(this, "账号或密码不符合规则", Toast.LENGTH_SHORT).show();
                } else {
                    presenter.getRegistData(registPhone.getText().toString(), registPassword.getText().toString());
                }
                break;
            case R.id.visitor_login:
                Intent visitor = new Intent(RegistActivity.this, MainActivity.class);
                startActivity(visitor);
                break;
        }
    }

    /**
     * 判断是否为手机号
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        String telRegex = "[1][35789]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        } else
            return mobiles.matches(telRegex);
    }

    @Override
    public void finish() {
        super.finish();
        //系统自带动画--从左向右滑动的效果
        //        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        //系统自带动画--从右向左滑动的效果
        overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
    }

    @Override
    public void onSucceed(RegistBean bean) {
        if (bean.getCode().equals("0")) {
            Toast.makeText(this, bean.getMsg(), Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, bean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Exception e) {

    }
}
