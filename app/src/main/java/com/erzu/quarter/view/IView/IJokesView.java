package com.erzu.quarter.view.IView;

import com.erzu.quarter.model.bean.JokesBean;

/**
 * Created by 超Sir on 2018/1/22.
 */

public interface IJokesView {

    void Succeed(JokesBean jokesBean);
    void Failure(Exception e);

}
