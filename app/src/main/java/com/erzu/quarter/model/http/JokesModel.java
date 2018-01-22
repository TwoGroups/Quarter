package com.erzu.quarter.model.http;

import com.erzu.quarter.model.bean.JokesBean;
import com.erzu.quarter.model.httpfz.APIFactory;
import com.erzu.quarter.model.httpfz.AbstractObserver;

import java.util.HashMap;

/**
 * Created by 超Sir on 2018/1/22.
 */

public class JokesModel {

public void getData(final JokesModelCallBack jokesModelCallBack){

    HashMap<String, String> map = new HashMap<>();
    map.put("source","android");
    map.put("appVersion","101");
    map.put("page","1");


    APIFactory.getInstance().get1("/quarter/getJokes",map,new AbstractObserver<JokesBean>() {
        @Override
        public void onSuccess(JokesBean jokesBean) {
            jokesModelCallBack.Succeed(jokesBean);
        }

        @Override
        public void onFailure() {
        }
    });


}



    public interface JokesModelCallBack{
        void Succeed(JokesBean jokesBean);
        void Failure(Exception e);
    }

}



