package com.erzu.quarter.view.IView;

import com.erzu.quarter.model.bean.CollectBean;

/**
 * Created by hp on 2018/2/3.
 */

public interface ICollectView {
    void onSucceed(CollectBean collectBean);

    void onFailure(Exception e);
}
