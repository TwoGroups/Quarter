package com.erzu.quarter.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.erzu.quarter.R;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }
}
