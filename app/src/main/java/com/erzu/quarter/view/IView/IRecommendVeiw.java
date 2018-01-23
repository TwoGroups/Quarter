package com.erzu.quarter.view.IView;

import com.erzu.quarter.model.bean.RecommendBannerBean;
import com.erzu.quarter.model.bean.RecommendVideoBean;

/**
 * Created by samsung on 2018/1/22.
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
