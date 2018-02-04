package com.erzu.quarter.model.http;

import com.erzu.quarter.model.bean.CollectBean;
import com.erzu.quarter.model.httpfz.APIFactory;
import com.erzu.quarter.model.httpfz.AbstractObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 2018/2/3.
 */

public class CollectModel {
    public void Collect(int uid, String token, final CollectCallBack collectCallBack) {
        //quarter/getFavorites?&source=android&appVersion=101&token=4DBFB1AFEE4D3FB13325C051A227CF1F&uid=2686
        Map<String,String> map = new HashMap<>();
        map.put("source","android");
        map.put("appVersion","101");
        map.put("uid",uid+"");
        map.put("token",token);
        APIFactory.getInstance().get1("/quarter/getFavorites?", map, new AbstractObserver<CollectBean>() {
            @Override
            public void onSuccess(CollectBean collectBean) {
                collectCallBack.Succeed(collectBean);
            }

            @Override
            public void onFailure() {

            }
        });
    }

    public interface CollectCallBack {
        void Succeed(CollectBean collectBean);

        void Failure(Exception e);
    }
}
