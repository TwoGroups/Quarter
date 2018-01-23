package com.erzu.quarter.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.erzu.quarter.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //隐藏标题栏
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}
