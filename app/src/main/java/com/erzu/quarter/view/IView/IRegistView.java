package com.erzu.quarter.view.IView;

import com.erzu.quarter.model.bean.RegistBean;

/**
 * Created by War on 2018/1/25.
 */

public interface IRegistView {
    void onSucceed(RegistBean bean);

    void onFailure(Exception e);
}
