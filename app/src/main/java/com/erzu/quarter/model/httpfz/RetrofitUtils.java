package com.erzu.quarter.model.httpfz;

import java.lang.reflect.Proxy;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by hp on 2018/1/22.
 */

public class RetrofitUtils {
    private static IGetService service = null;
    public static IGetService getService = null;

    //http://api.tianapi.com/nba/?key=71e58b5b2f930eaf1f937407acde08fe&num=10
    //单例模式
    public static IGetService getInstance() {
        if (service == null) {
            synchronized (RetrofitUtils.class) {
                if (service == null) {
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://www.zhaoapi.cn")
                            .addConverterFactory(ScalarsConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(OkHttpUtils.getInstance())
                            .build();

                    service = retrofit.create(IGetService.class);
                }
            }
        }
        return service;
    }


}
