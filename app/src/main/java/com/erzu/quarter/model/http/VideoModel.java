package com.erzu.quarter.model.http;

import com.erzu.quarter.model.bean.HotVideoBean;
import com.erzu.quarter.model.bean.VideoRecommendBean;
import com.erzu.quarter.model.httpfz.APIFactory;
import com.erzu.quarter.model.httpfz.AbstractObserver;

import java.util.HashMap;

/**
 * Created by War on 2018/1/23.
 */

public class VideoModel {

    public void getHotData(String pageSize, final VideoModelCallBack videoModelCallBack) {

        HashMap<String, String> map = new HashMap<>();
        map.put("source", "android");
        map.put("appVersion", "101");
        map.put("page", pageSize);


        APIFactory.getInstance().get1("/quarter/getHotVideos", map, new AbstractObserver<HotVideoBean>() {

            @Override
            public void onSuccess(HotVideoBean bean) {
                videoModelCallBack.Succeed(bean);
            }

            @Override
            public void onFailure() {
                videoModelCallBack.Failure(new Exception("数据出错"));
            }
        });

    }

    public interface VideoModelCallBack {
        void Succeed(HotVideoBean videoBean);

        void Failure(Exception e);
    }
}
