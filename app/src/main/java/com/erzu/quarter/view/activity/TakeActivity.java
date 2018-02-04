package com.erzu.quarter.view.activity;

import android.content.Intent;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.erzu.quarter.R;
import com.erzu.quarter.utils.FormatUtil;
import com.erzu.quarter.view.adapter.TakeAdapter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TakeActivity extends AppCompatActivity {
    @BindView(R.id.fenhui)
    TextView fenhui;
    @BindView(R.id.photo)
    ImageView photo;
    @BindView(R.id.camera_photo)
    ImageView camera_photo;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private String tag = "MaHaochen_______CameraActivity";
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private Camera camera;
    private MediaRecorder mediaRecorder;
    private Button photoButton;  //拍照按钮
    private Button vedioButton;  //摄像按钮
    private TextView timeTextView;

    protected boolean isPreview = false; //摄像区域是否准备良好
    private boolean isRecording = true; // true表示没有录像，点击开始；false表示正在录像，点击暂停
    private boolean bool;
    private File picture;
    private int hour = 0;
    private int minute = 0;     //计时专用
    private int second = 0;

    private File mRecVedioPath;
    List<String> mDatas;
    List<String> textList;
    private static final int MEDIA_TYPE_IMAGE = 1;
    private static final int MEDIA_TYPE_VIDEO = 2;
    private File file = null;
    String uri = "https://v2.modao.cc/uploads3/images/1132/11326014/raw_1500978299.jpeg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take);
        ButterKnife.bind(this);
        initCamera();
        initViews();
        initDatas();
        fenhui.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        photo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlbum();
            }

            private void openAlbum() {
                Intent albumIntent = new Intent(Intent.ACTION_PICK, null);
                albumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(albumIntent, RESULT_OK);
            }
        });
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        TakeAdapter takeAdapter = new TakeAdapter(this, mDatas, textList);
        recyclerView.setAdapter(takeAdapter);


    }

    private void initDatas() {
        mDatas=new ArrayList<>();
       mDatas.add(uri);mDatas.add(uri);mDatas.add(uri);mDatas.add(uri);mDatas.add(uri);
        mDatas.add(uri);mDatas.add(uri);mDatas.add(uri);mDatas.add(uri);mDatas.add(uri);
        textList = new ArrayList<>();
        textList.add("原画");
        textList.add("唯美");
        textList.add("复古");
        textList.add("阿宝色");
        textList.add("暖色");
        textList.add("青春");
        textList.add("阳光");
        textList.add("黑白");
        textList.add("暗色");
        textList.add("红色");
    }

    //初始化摄像头
    private void initCamera() {
        mRecVedioPath = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/mahc/video/temp/");
        if (!mRecVedioPath.exists()) {
            mRecVedioPath.mkdirs();
        }
        surfaceView = (SurfaceView) findViewById(R.id.camera_surfaceview);
        SurfaceHolder cameraSurfaceHolder = surfaceView.getHolder();
        cameraSurfaceHolder.addCallback(new Callback() {

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    camera = Camera.open();
                    //设置Camera的角度/方向
                    camera.setDisplayOrientation(0);
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setPreviewFrameRate(5); // 每秒5帧
                    parameters.setPictureFormat(ImageFormat.JPEG);// 设置照片的输出格式
                    parameters.set("jpeg-quality", 85);// 照片质量
                    camera.setParameters(parameters);
                    camera.setPreviewDisplay(holder);
                    isPreview = true;
                    camera.startPreview();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                surfaceHolder = holder;
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                       int height) {
                surfaceHolder = holder;
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                if (camera != null) {
                    if (isPreview) {
                        camera.stopPreview();
                        isPreview = false;
                    }
                    camera.release();
                    camera = null; // 记得释放Camera
                }
                surfaceView = null;
                surfaceHolder = null;
                mediaRecorder = null;
            }
        });
        //开发时建议设置
        //This method was deprecated in API level 11. this is ignored, this value is set automatically when needed.
        cameraSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    //初始化视图组件
    private void initViews() {
        timeTextView = (TextView) findViewById(R.id.camera_time);
        timeTextView.setVisibility(View.GONE);



        camera_photo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TakeActivity.this,PutondisplayActivity.class);
                startActivity(intent);

            }
        });

    }



    /*
        * 定时器设置，实现计时
        */
    private Handler handler = new Handler();
    private Runnable task = new Runnable() {
        public void run() {
            if (bool) {
                handler.postDelayed(this, 1000);
                second++;
                if (second >= 60) {
                    minute++;
                    second = second % 60;
                }
                if (minute >= 60) {
                    hour++;
                    minute = minute % 60;
                }
                timeTextView.setText(FormatUtil.format(hour) + ":" + FormatUtil.format(minute) + ":"
                        + FormatUtil.format(second));
            }
        }
    };



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case RESULT_OK:
                if (MEDIA_TYPE_IMAGE==requestCode){
                    if (file==null){
                        // 测试几个机型 file不会为null 但是有一款Lenovo的调试机 获取不到file
                        // 所以 我不打算继续写自己实现获取拍照或者录像 并实现相关操作了 我打算写框架的相关博文
                        System.out.println("ceshi file null");
                    }else {
                        System.out.println("ceshi image onActivityResult = "+file);
                        Toast.makeText(TakeActivity.this, "ceshi image onActivityResult = "+file, Toast.LENGTH_LONG).show();
                    }
                    //Uri uri = data.getData(); // 因为我们保存到SDCard，所以这边取不到uri，如果没有保存，则可以获取
                }else if (MEDIA_TYPE_VIDEO==requestCode){

                }
                break;
        }
    }

    /**
     * 根据文件返回一个路径
     */
    private Uri getOutputMediaFileUri(int type){
        file = getOutputMediaFile(type);
        System.out.println("ceshi getOutputMediaFileUri = " + Uri.fromFile(file));
        return Uri.fromFile(file);
    }
    /**
     * rootPath 路径
     * File.separator  路径的分隔符
     * System.currentTimeMillis() 时间
     * 最后加上格式
     */
    private File getOutputMediaFile(int type){
        //File file = null;
        String rootPath = null;
        switch (type){
            case MEDIA_TYPE_IMAGE:
                rootPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath();
                file = new File(rootPath+File.separator+System.currentTimeMillis()+".jpg");
                System.out.println("ceshi image = "+file);
                break;
            case  MEDIA_TYPE_VIDEO:
                rootPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getPath();
                file = new File(rootPath+File.separator+System.currentTimeMillis()+".mp4");
                System.out.println("ceshi video = "+file);
                break;
        }
        System.out.println("ceshi return = "+file);
        return file;
    }
}
