package com.erzu.quarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.erzu.quarter.R;
import com.erzu.quarter.view.adapter.PutondisolayAdapter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PutondisplayActivity extends AppCompatActivity {
    String url = "https://v2.modao.cc/uploads3/images/1132/11325136/raw_1500976677.gif";
    String uri = "https://v2.modao.cc/uploads3/images/1132/11326014/raw_1500978299.jpeg";
    @BindView(R.id.put_sdv)
    SimpleDraweeView putSdv;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.fenhui)
    TextView fenhui;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.photo)
    TextView photo;
    List<String> putlist;
    @BindView(R.id.rec)
    RecyclerView rec;
    List<String> textList;
    @BindView(R.id.but)
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_putondisplay);
        putlist = new ArrayList<>();
        putlist.add(uri);
        putlist.add(uri);
        putlist.add(uri);
        putlist.add(uri);
        textList = new ArrayList<>();
        textList.add("原色");
        textList.add("柔光");
        textList.add("复古");
        textList.add("黑白");

        ButterKnife.bind(this);
        fenhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(url)
                .setAutoPlayAnimations(true)
                .build();
        putSdv.setController(controller);
        //设置布局管理器
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        rec.setLayoutManager(linearLayoutManager);
        rec.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        PutondisolayAdapter putondisolayAdapter = new PutondisolayAdapter(this, putlist, textList);
        rec.setAdapter(putondisolayAdapter);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PutondisplayActivity.this,PreviewActivity.class));
            }
        });
    }
}
