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
import com.erzu.quarter.model.bean.EventBeanLogin;
import com.erzu.quarter.model.bean.LoginBean;
import com.erzu.quarter.presenter.LogInPresenter;
import com.erzu.quarter.utils.SharedPrefsUtil;
import com.erzu.quarter.view.IView.ILoginView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityLogin extends AppCompatActivity implements ILoginView {

    @BindView(R.id.login_back)
    ImageView loginBack;
    @BindView(R.id.register_account)
    TextView registerAccount;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.login_account)
    EditText loginAccount;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.forget_password)
    TextView forgetPassword;
    @BindView(R.id.visitor_login)
    TextView visitorLogin;
    private LogInPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);
        presenter = new LogInPresenter(this);
    }

    @OnClick({R.id.login_back, R.id.register_account, R.id.login_btn, R.id.forget_password, R.id.visitor_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_back:
                finish();
                break;
            case R.id.register_account:
                Intent intent = new Intent(ActivityLogin.this, RegistActivity.class);
                startActivity(intent);
                break;
            case R.id.login_btn:
                if (TextUtils.isEmpty(loginAccount.getText().toString()) || TextUtils.isEmpty(loginPassword.getText().toString())) {
                    Toast.makeText(this, "账号和密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    presenter.getLoginData(loginAccount.getText().toString(), loginPassword.getText().toString());
                }
                break;
            case R.id.forget_password:
                Intent findPass = new Intent(ActivityLogin.this, FindPasswordActivity.class);
                startActivity(findPass);
                break;
            case R.id.visitor_login:
                Intent visitor = new Intent(ActivityLogin.this, MainActivity.class);
                startActivity(visitor);
                finish();
                break;
        }
    }

    @Override
    public void finish() {
        super.finish();
        //系统自带动画--从左向右滑动的效果
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @Override
    public void onSucceed(LoginBean bean) {
        if (bean.getCode().equals("0")) {
            //登录成功跳转
            EventBus.getDefault().postSticky(new EventBeanLogin(bean.getData().getIcon(),bean.getData().getUsername()));
            Intent login = new Intent(ActivityLogin.this, MainActivity.class);
            startActivity(login);
            //存储数据，在MySetting文件中存储键值对
            SharedPrefsUtil.putValue(this, "Account", "phone", bean.getData().getMobile());
            SharedPrefsUtil.putValue(this, "Account", "password", bean.getData().getPassword());
            SharedPrefsUtil.putValue(this, "Account", "token", bean.getData().getToken());
            SharedPrefsUtil.putValue(this, "Account", "username", bean.getData().getUsername());
            SharedPrefsUtil.putValue(this, "Account", "nickname", bean.getData().getNickname());
            SharedPrefsUtil.putValue(this, "Account", "uid", bean.getData().getUid());
            finish();
        } else {
            //登录失败提示信息
            Toast.makeText(this, bean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Exception e) {

    }
}
