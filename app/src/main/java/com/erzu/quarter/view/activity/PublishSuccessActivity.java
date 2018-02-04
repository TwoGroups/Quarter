package com.erzu.quarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.erzu.quarter.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PublishSuccessActivity extends AppCompatActivity {

    @BindView(R.id.butpublish)
    Button butpublish;
    @BindView(R.id.fenhui)
    TextView fenhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_success);
        ButterKnife.bind(this);
        fenhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        butpublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PublishSuccessActivity.this, UserActivity.class));
            }
        });
    }
}
