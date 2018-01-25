package com.erzu.quarter.view.IView;

import com.erzu.quarter.model.bean.LoginBean;

/**
 * Created by War on 2018/1/24.
 */

public interface ILoginView {
    void onSucceed(LoginBean bean);

    void onFailure(Exception e);

}
