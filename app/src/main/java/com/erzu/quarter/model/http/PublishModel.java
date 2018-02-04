package com.erzu.quarter.model.http;

import com.erzu.quarter.model.bean.WriteJokeBean;
import com.erzu.quarter.model.httpfz.APIFactory;
import com.erzu.quarter.model.httpfz.AbstractObserver;

import java.util.HashMap;

/**
 * Created by War on 2018/2/4.
 */

public class PublishModel {
    public void getData(String joke, String uid, String token, final PublishModelCallBack publishModelCallBack) {

        HashMap<String, String> map = new HashMap<>();
        map.put("source", "android");
        map.put("uid", uid);
        map.put("token", token);
        map.put("appVersion", "101");
        map.put("content", joke);
        APIFactory.getInstance().get1("/quarter/publishJoke", map, new AbstractObserver<WriteJokeBean>() {

            @Override
            public void onSuccess(WriteJokeBean writeJokeBean) {
                publishModelCallBack.Succeed(writeJokeBean);
            }

            @Override
            public void onFailure() {
            }
        });
    }

    public interface PublishModelCallBack {
        void Succeed(WriteJokeBean jokesBean);

        void Failure(Exception e);
    }
}
