package com.erzu.quarter.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by hzwangchenyan on 2017/3/30.
 */
public class HttpInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .addHeader("source", "android")
                .addHeader("appVersion", "101")
                .build();
        return chain.proceed(request);
    }
}
