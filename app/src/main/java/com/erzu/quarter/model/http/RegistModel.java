package com.erzu.quarter.model.http;

import com.erzu.quarter.model.bean.LoginBean;
import com.erzu.quarter.model.bean.RegistBean;
import com.erzu.quarter.model.httpfz.APIFactory;
import com.erzu.quarter.model.httpfz.AbstractObserver;

import java.util.HashMap;

/**
 * Created by War on 2018/1/25.
 */

public class RegistModel {
    public void regist(String mobile, String password, final RegistModelCallBack registModelCallBack) {

        HashMap<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("password", password);
        map.put("source", "android");
        map.put("regType","0");


        APIFactory.getInstance().get1("/quarter/register", map, new AbstractObserver<RegistBean>() {

            @Override
            public void onSuccess(RegistBean registBean) {
                registModelCallBack.onSucceed(registBean);
            }

            @Override
            public void onFailure() {
                registModelCallBack.onFailure(new Exception("数据出错"));
            }
        });

    }

    public interface RegistModelCallBack {
        void onSucceed(RegistBean registBean);
        void onFailure(Exception e);
    }
}
