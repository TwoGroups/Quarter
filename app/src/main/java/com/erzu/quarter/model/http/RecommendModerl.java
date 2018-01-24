package com.erzu.quarter.model.http;

import com.erzu.quarter.model.bean.RecommendBannerBean;
import com.erzu.quarter.model.bean.RecommendVideoBean;
import com.erzu.quarter.model.bean.VideoRecommendBean;
import com.erzu.quarter.model.httpfz.APIFactory;
import com.erzu.quarter.model.httpfz.AbstractObserver;

/**
 * Created by samsung on 2018/1/22.
 */

public class RecommendModerl {
    /**
     * Banner轮播
     *
     * @param callBack
     */

    public void getData(final RecomendModerlCallBack callBack) {
        String url = "/quarter/getAd";

        APIFactory.getInstance().get1(url, new AbstractObserver<RecommendBannerBean>() {
            @Override
            public void onSuccess(RecommendBannerBean recommendBannerBean) {
                callBack.onSuccess(recommendBannerBean);
            }

            @Override
            public void onFailure() {
                callBack.onFailure(new Exception());
            }
        });

        }

    public void getVideo(final RecommendModerlCallBackVideo callBackVideo) {
        String url = "/quarter/getVideos?source=android&appVersion=101&type=1&page=1";
        APIFactory.getInstance().get1(url, new AbstractObserver<RecommendVideoBean>() {
            @Override
            public void onSuccess(RecommendVideoBean recommendVideoBean) {
                callBackVideo.SuccessVideo(recommendVideoBean);
            }

            @Override
            public void onFailure() {
                callBackVideo.Failuer(new Exception());
            }
        });
    }

    public interface RecomendModerlCallBack {
        void onSuccess(RecommendBannerBean recommendBannerBean);

        void onFailure(Exception e);
    }

    public interface RecommendModerlCallBackVideo {
        void SuccessVideo(RecommendVideoBean recommendVideoBean);

        void Failuer(Exception e);
    }



}
