package com.erzu.quarter.view.IView;


import com.erzu.quarter.model.bean.RecommendVideoBean;

/**
 * Created by War on 2018/1/23.
 */

public interface IVideoView {
    void onSucceed(RecommendVideoBean videosBean);

    void onFailure(Exception e);

}
