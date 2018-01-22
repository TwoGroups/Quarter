package com.erzu.quarter.model.manconsole;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hp on 2018/1/22.
 */

public class APIFactory {
    //单例模式
    private static APIFactory factory = null;

    public static APIFactory getInstance(){
        if(factory==null){
            synchronized (APIFactory.class){
                if(factory==null){
                    factory = new APIFactory();
                }
            }
        }
        return factory;
    }

    //这里面写方法.
    public void get1(String url, Map<String,String> map, Observer<String> observer){
        //调用retrofit工具类的方法
        RetrofitUtils.getInstance().get1(url, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void get1(String url,Observer<String> observer){
        RetrofitUtils.getInstance().get1(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void post1(String url,Map<String,String> map,Observer<String> observer){

        RetrofitUtils.getInstance().post1(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void post1(String url,Observer<String> observer){

        RetrofitUtils.getInstance().post1(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
