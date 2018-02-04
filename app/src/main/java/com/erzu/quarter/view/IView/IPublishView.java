package com.erzu.quarter.view.IView;

import com.erzu.quarter.model.bean.WriteJokeBean;

/**
 * Created by War on 2018/2/4.
 */

public interface IPublishView {
    void Succeed(WriteJokeBean jokesBean);

    void Failure(Exception e);
}
