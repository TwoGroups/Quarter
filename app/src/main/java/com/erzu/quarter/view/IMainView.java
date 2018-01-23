package com.erzu.quarter.view;


import com.erzu.quarter.model.bean.VideoRecommendBean;

/**
 * Created by caojun on 2017/12/26.
 */

public interface IMainView extends IBaseView {
    void onSuccess(VideoRecommendBean bean);
}
