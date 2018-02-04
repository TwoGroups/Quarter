package com.erzu.quarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.erzu.quarter.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创作页面
 */
public class CreationActivity extends AppCompatActivity {

    @BindView(R.id.creation_fh)
    TextView creationFh;
    @BindView(R.id.creation_video)
    ImageView creationVideo;
    @BindView(R.id.creation_jokes)
    ImageView creationJokes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);
        ButterKnife.bind(this);
        iniVideo();
    }

    private void iniVideo() {
        creationVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreationActivity.this, TakeActivity.class));
            }
        });

    }

    @OnClick(R.id.creation_fh)
    public void onViewClicked() {
        //点击取消按钮销毁页面
        finish();
    }

    @OnClick({R.id.creation_video, R.id.creation_jokes})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.creation_video:

                break;
            case R.id.creation_jokes:
                Intent intent = new Intent(CreationActivity.this, WriteJokeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
