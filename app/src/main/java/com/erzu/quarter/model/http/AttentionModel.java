package com.erzu.quarter.model.http;

import android.content.Context;

import com.erzu.quarter.model.bean.AttentionBean;
import com.erzu.quarter.model.bean.JokesBean;
import com.erzu.quarter.model.httpfz.APIFactory;
import com.erzu.quarter.model.httpfz.AbstractObserver;
import com.erzu.quarter.utils.SharedPrefsUtil;

import java.util.HashMap;

/**
 * Created by 超Sir on 2018/2/3.
 */

public class AttentionModel {

    public void getData(int uid, String token,final AttentionModelCallBack attentionModelCallBack) {

        HashMap<String, String> map = new HashMap<>();
        map.put("source", "android");
        map.put("appVersion", "101");
        map.put("uid", uid+"");
        map.put("token", token);

        APIFactory.getInstance().get1("/quarter/getFollowUsers", map, new AbstractObserver<AttentionBean>() {
            @Override
            public void onSuccess(AttentionBean attentionBean) {
                attentionModelCallBack.Succeed(attentionBean);
            }

            @Override
            public void onFailure() {
                attentionModelCallBack.Failure(new Exception("请求失败"));
            }
        });


    }

    public interface AttentionModelCallBack {
        void Succeed(AttentionBean attentionBean);

        void Failure(Exception e);
    }
}
