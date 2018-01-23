package com.erzu.quarter.utils;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by caojun on 2017/12/26.
 */

public class HttpUtils<T> {
    private static final String BASE_URL = "http://tingapi.ting.baidu.com/v1/restserver/ting";
    private static final String METHOD_GET_MUSIC_LIST = "?method=baidu.ting.billboard.billList&format=json";
    private static HttpUtilsCallback mHttpUtilsCallback = null;


    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            T obj = (T) msg.obj;
            mHttpUtilsCallback.callbackOK(obj);
        }
    };

    //HttpUtilsCallback httpUtilsCallback = MainPresenter
    public void loadData(HttpUtilsCallback httpUtilsCallback, String type, int page, final Class<T> classOfT) {
        mHttpUtilsCallback = httpUtilsCallback;
        String url = "https://www.zhaoapi.cn/quarter/getVideos?type=" + type + "&page=" + page + "&source=android&appVersion=101";
        Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new HttpInterceptor()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mHttpUtilsCallback.callbackErr(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                T t = gson.fromJson(string, classOfT);
                //httpUtilsCallback.callbackOK(testBean);
                Message message = handler.obtainMessage();
                message.obj = t;
                handler.sendMessage(message);
                //回调数据
            }
        });

    }

    public interface HttpUtilsCallback<T> {
        void callbackOK(T testBean);

        void callbackErr(String errMessage);
    }
}
