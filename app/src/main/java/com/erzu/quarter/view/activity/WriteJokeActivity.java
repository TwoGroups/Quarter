package com.erzu.quarter.view.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.WriteJokeBean;
import com.erzu.quarter.presenter.PublishPresenter;
import com.erzu.quarter.utils.SharedPrefsUtil;
import com.erzu.quarter.view.IView.IPublishView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WriteJokeActivity extends AppCompatActivity implements IPublishView, View.OnClickListener {

    @BindView(R.id.write_joke_back)
    TextView writeJokeBack;
    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.write_joke)
    TextView writeJoke;
    @BindView(R.id.main_head_rl)
    RelativeLayout mainHeadRl;
    @BindView(R.id.joke_content)
    EditText jokeContent;
    @BindView(R.id.joke_addImg)
    ImageView jokeAddImg;
    @BindView(R.id.tell_someOne)
    TextView tellSomeOne;
    @BindView(R.id.line)
    View line;
    private PublishPresenter presenter;
    private int uid;
    private String token;
    private View inflate;
    private TextView choosePhoto;
    private TextView takePhoto;
    private Button cancel;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_joke);
        ButterKnife.bind(this);
        presenter = new PublishPresenter(this);
        uid = SharedPrefsUtil.getValue(this, "Account", "uid", 1703);
        token = SharedPrefsUtil.getValue(this, "Account", "token", "3C4ADF7C7B16ADC561AB30AE202A2ED0");

    }

    @OnClick({R.id.write_joke_back, R.id.write_joke, R.id.joke_addImg, R.id.tell_someOne})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.write_joke_back:
                dialog = new Dialog(this, R.style.ActionSheetDialogStyle);
                inflate = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null);
                choosePhoto = inflate.findViewById(R.id.choosePhoto);
                takePhoto = inflate.findViewById(R.id.takePhoto);
                cancel = inflate.findViewById(R.id.btn_cancel);
                choosePhoto.setOnClickListener(WriteJokeActivity.this);
                takePhoto.setOnClickListener(this);
                cancel.setOnClickListener(this);
                dialog.setContentView(inflate);
                Window dialogWindow = dialog.getWindow();
                dialogWindow.setGravity(Gravity.BOTTOM);
                WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                lp.y = 20;
                dialogWindow.setAttributes(lp);
                dialog.show();
                break;
            case R.id.write_joke:
                if (!TextUtils.isEmpty(jokeContent.getText().toString())) {
                    presenter.putJokesData(jokeContent.getText().toString(), uid + "", token);
                    //                    new Intent(this,F);
                }
                break;
            case R.id.joke_addImg:

                break;
            case R.id.tell_someOne:
                break;
        }
    }

    @Override
    public void Succeed(WriteJokeBean jokesBean) {
        if (jokesBean.getCode().equals("0")) {
            Toast.makeText(this, jokesBean.getMsg(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(WriteJokeActivity.this, PublishSuccessActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void Failure(Exception e) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.takePhoto:
                Toast.makeText(this, "已保存", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                finish();
                break;
            case R.id.choosePhoto:
                Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                finish();
                break;
            case R.id.btn_cancel:
                dialog.dismiss();
                finish();
        }
    }
}
