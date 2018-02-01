package com.erzu.quarter.model.http;

import com.erzu.quarter.model.bean.SearchBean;
import com.erzu.quarter.model.bean.SearchInterstedBean;
import com.erzu.quarter.model.httpfz.APIFactory;
import com.erzu.quarter.model.httpfz.AbstractObserver;

import java.util.HashMap;

/**
 * Created by lenovo on 2018/1/26.
 */

public class SearchModel {

    public  void search(final String keyWords, final SearchModelCallBack searchModelCallBack){
        HashMap<String,String> map=new HashMap<>();
        map.put("keyWords",keyWords);
        map.put("source","android");
        map.put("appVersion","101");
        APIFactory.getInstance().get1("/quarter/searchFriends", map, new AbstractObserver<SearchBean>() {
            @Override
            public void onSuccess(SearchBean searchBean) {

                 searchModelCallBack.onSuccess(searchBean);

            }

            @Override
            public void onFailure() {
                new Exception("出错");
            }
        });
    }

    public  interface  SearchModelCallBack{
        void  onSuccess(SearchBean searchBean);

        void Failure(Exception e);
    }
}
