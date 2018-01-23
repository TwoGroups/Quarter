package com.erzu.quarter.view.IView;

import com.erzu.quarter.model.bean.JokesBean;

/**
 * Created by War on 2018/1/23.
 */

public interface IJokesView {

    void Succeed(JokesBean jokesBean);
    void Failure(Exception e);

}
