package com.erzu.quarter.model.httpfz;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


/**
 * Created by hp on 2018/1/22.
 */

public class OkHttpUtils {
    private static OkHttpClient client = null;

    public static OkHttpClient getInstance(){
        if(client==null){
            synchronized (OkHttpUtils.class){
                if(client==null){
                    client = new OkHttpClient.Builder()
                            .connectTimeout(2000, TimeUnit.SECONDS)
                            .writeTimeout(2000,TimeUnit.SECONDS)
                            .readTimeout(2000,TimeUnit.SECONDS)
                            .addInterceptor(new SongInterceptor())
                            .build();
                }
            }
        }
        return client;
    }
}
