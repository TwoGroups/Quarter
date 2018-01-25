package com.erzu.quarter.presenter;

import com.erzu.quarter.model.bean.RegistBean;
import com.erzu.quarter.model.http.RegistModel;
import com.erzu.quarter.view.IView.IRegistView;

/**
 * Created by War on 2018/1/25.
 */

public class RegistPresenter {
    private IRegistView view;
    private RegistModel model;

    public RegistPresenter(IRegistView view) {
        this.view = view;
        this.model = new RegistModel();
    }

    public void getRegistData(String mobile, String password) {
        model.regist(mobile, password, new RegistModel.RegistModelCallBack() {
            @Override
            public void onSucceed(RegistBean registBean) {
                view.onSucceed(registBean);
            }

            @Override
            public void onFailure(Exception e) {
                view.onFailure(e);
            }
        });
    }
}
