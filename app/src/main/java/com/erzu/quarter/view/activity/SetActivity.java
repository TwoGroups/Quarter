package com.erzu.quarter.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.EventBeanLogin;
import com.erzu.quarter.utils.SharedPrefsUtil;

import org.greenrobot.eventbus.EventBus;

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

        messageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick(R.id.edit_login)
    public void onViewClicked() {
        SharedPrefsUtil.putValue(this, "Account", "phone", "");
        SharedPrefsUtil.putValue(this, "Account", "password", "");
        SharedPrefsUtil.putValue(this, "Account", "token", "");
        SharedPrefsUtil.putValue(this, "Account", "nickname", "");
        SharedPrefsUtil.putValue(this, "Account", "username", "游客12306");
        SharedPrefsUtil.putValue(this, "Account", "uid", 0);
        EventBus.getDefault().postSticky(new EventBeanLogin("","游客12306"));
        finish();
    }
}
