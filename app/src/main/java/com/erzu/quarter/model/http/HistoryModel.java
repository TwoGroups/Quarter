package com.erzu.quarter.model.http;

import com.erzu.quarter.model.bean.SearchBean;
import com.erzu.quarter.model.bean.SearchHistoryBean;
import com.erzu.quarter.model.httpfz.APIFactory;
import com.erzu.quarter.model.httpfz.AbstractObserver;

import java.util.HashMap;

/**
 * Created by lenovo on 2018/1/26.
 */

public class HistoryModel {

    public  void searchHistory(final SearchHistoryModelCallBack searchHistoryModelCallBack){
        HashMap<String,String> map=new HashMap<>();
        map.put("source","android");
        map.put("appVersion","101");
        map.put("keyWords","李");
        APIFactory.getInstance().get1("/quarter/searchFriends", map, new AbstractObserver<SearchBean>() {
            @Override
            public void onSuccess(SearchBean historyBean) {

                 searchHistoryModelCallBack.onSuccess(historyBean);
            }

            @Override
            public void onFailure() {
                new Exception("出错");
            }
        });
    }

    public  interface  SearchHistoryModelCallBack{
        void  onSuccess(SearchBean historyBean);

        void Failure(Exception e);
    }
}
