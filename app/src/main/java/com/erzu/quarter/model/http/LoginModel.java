package com.erzu.quarter.model.http;

import com.erzu.quarter.model.bean.LoginBean;
import com.erzu.quarter.model.httpfz.APIFactory;
import com.erzu.quarter.model.httpfz.AbstractObserver;

import java.util.HashMap;

/**
 * Created by War on 2018/1/23.
 */

public class LoginModel {
    public void Login(String mobile, String password, final LoginModelCallBack loginModelCallBack) {

        HashMap<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("password", password);
        map.put("source", "android");


        APIFactory.getInstance().get1("/user/login", map, new AbstractObserver<LoginBean>() {

            @Override
            public void onSuccess(LoginBean bean) {
                loginModelCallBack.Succeed(bean);
            }

            @Override
            public void onFailure() {
                loginModelCallBack.Failure(new Exception("数据出错"));
            }
        });

    }

    public interface LoginModelCallBack {
        void Succeed(LoginBean loginBean);

        void Failure(Exception e);
    }
}
