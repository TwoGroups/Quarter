package com.erzu.quarter.model.http;

import com.erzu.quarter.model.bean.SearchHistoryBean;
import com.erzu.quarter.model.bean.SearchInterstedBean;
import com.erzu.quarter.model.httpfz.APIFactory;
import com.erzu.quarter.model.httpfz.AbstractObserver;

import java.util.HashMap;

/**
 * Created by lenovo on 2018/1/26.
 */

public class InterstedModel {

    public  void searchIntersted(final SearchInterstedModelCallBack searchInterstedModelCallBack){
        HashMap<String,String> map=new HashMap<>();
        map.put("source","android");
        map.put("appVersion","101");
        APIFactory.getInstance().get1("/quarter/randomFriends", map, new AbstractObserver<SearchInterstedBean>() {
            @Override
            public void onSuccess(SearchInterstedBean interstedBean) {

                 searchInterstedModelCallBack.onSuccess(interstedBean);
            }

            @Override
            public void onFailure() {
                new Exception("出错");
            }
        });
    }

    public  interface  SearchInterstedModelCallBack{
        void  onSuccess(SearchInterstedBean interstedBean);

        void Failure(Exception e);
    }
}
