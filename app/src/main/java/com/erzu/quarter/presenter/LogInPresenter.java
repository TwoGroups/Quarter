package com.erzu.quarter.presenter;

import com.erzu.quarter.model.bean.LoginBean;
import com.erzu.quarter.model.http.LoginModel;
import com.erzu.quarter.view.IView.ILoginView;

/**
 * Created by War on 2018/1/23.
 */

public class LogInPresenter {
    private ILoginView view;
    private LoginModel model;

    public LogInPresenter(ILoginView view) {
        this.view = view;
        this.model = new LoginModel();
    }

    public void getLoginData(String mobile, String password) {
        model.Login(mobile, password, new LoginModel.LoginModelCallBack() {
            @Override
            public void Succeed(LoginBean loginBean) {
                view.onSucceed(loginBean);
            }

            @Override
            public void Failure(Exception e) {
                view.onFailure(e);
            }
        });
    }
}
