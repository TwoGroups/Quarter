package com.erzu.quarter.presenter;

import com.erzu.quarter.model.bean.RecommendBannerBean;
import com.erzu.quarter.model.bean.RecommendVideoBean;
import com.erzu.quarter.model.bean.VideoRecommendBean;
import com.erzu.quarter.model.http.RecommendModerl;
import com.erzu.quarter.view.IView.IRecommendVeiw;

/**
 * Created by samsung on 2018/1/22.
 */

public class RecommendPresenter {
    IRecommendVeiw iRecommendVeiw;
    RecommendModerl recommendModerl;

    public RecommendPresenter(IRecommendVeiw iRecommendVeiw) {
        this.iRecommendVeiw = iRecommendVeiw;
        this.recommendModerl = new RecommendModerl();
    }

    public void showRecomend() {
        recommendModerl.getData(new RecommendModerl.RecomendModerlCallBack() {
            @Override
            public void onSuccess(RecommendBannerBean recommendBannerBean) {
                iRecommendVeiw.onSuccess(recommendBannerBean);
            }

            @Override
            public void onFailure(Exception e) {
                iRecommendVeiw.onFailure(new Exception());
            }
        });
    }

    public void showVideo(String page) {
        recommendModerl.getVideo(page,new RecommendModerl.RecommendModerlCallBackVideo() {
            @Override
            public void SuccessVideo(RecommendVideoBean videoRecommendBean) {
                iRecommendVeiw.Success_video(videoRecommendBean);
            }

            @Override
            public void Failuer(Exception e) {
                iRecommendVeiw.Failure(new Exception());
            }
        });
    }
}
