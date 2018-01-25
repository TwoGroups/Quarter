package com.erzu.quarter.presenter;

import com.erzu.quarter.model.bean.HotVideoBean;
import com.erzu.quarter.model.bean.RecommendVideoBean;
import com.erzu.quarter.model.bean.VideoRecommendBean;
import com.erzu.quarter.model.http.VideoModel;
import com.erzu.quarter.view.IView.IVideoView;

/**
 * Created by War on 2018/1/26.
 */

public class VideoPresenter extends BasePresenter {
    private VideoModel model;
    private IVideoView view;

    public VideoPresenter(IVideoView view) {
        this.view = view;
        this.model = new VideoModel();
    }

    public void getHotVideoData(String pageSize) {
        model.getHotData(pageSize,new VideoModel.VideoModelCallBack() {
            @Override
            public void Succeed(RecommendVideoBean videoBean) {
                view.onSucceed(videoBean);
            }

            @Override
            public void Failure(Exception e) {
                view.onFailure(e);
            }
        });
    }
}
