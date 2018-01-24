package com.erzu.quarter.view.IView;

import com.erzu.quarter.model.bean.RecommendBannerBean;
import com.erzu.quarter.model.bean.RecommendVideoBean;
import com.erzu.quarter.model.bean.VideoRecommendBean;

/**
 * Created by War on 2018/1/23.
 */

public interface IRecommendVeiw {
    /**
     * Banner轮播
     *
     * @param recommendBannerBean
     */
    void onSuccess(RecommendBannerBean recommendBannerBean);

    void onFailure(Exception e);

    /**
     * 视频
     */
    void Success_video(RecommendVideoBean recommendVideoBean);

    void Failure(Exception e);
}
