package com.erzu.quarter.model.http;

import com.erzu.quarter.model.bean.RecommendBannerBean;
import com.erzu.quarter.model.bean.RecommendVideoBean;
import com.erzu.quarter.model.bean.VideoRecommendBean;
import com.erzu.quarter.model.httpfz.APIFactory;
import com.erzu.quarter.model.httpfz.AbstractObserver;

import java.util.HashMap;

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

    public void getVideo(String page,final RecommendModerlCallBackVideo callBackVideo) {
        HashMap<String,String> map=new HashMap<>();
        map.put("source","android");
        map.put("appVersion","101");
        map.put("page",page);


        APIFactory.getInstance().get1("/quarter/getVideos",map, new AbstractObserver<RecommendVideoBean>() {
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
