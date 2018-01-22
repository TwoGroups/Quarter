package com.erzu.quarter.presenter;

import com.erzu.quarter.model.bean.JokesBean;
import com.erzu.quarter.model.http.JokesModel;
import com.erzu.quarter.view.IView.IJokesView;

/**
 * Created by 超Sir on 2018/1/22.
 */

public class JokesPresenter {

    private IJokesView iJokesView;
    private JokesModel jokesModel;

    public JokesPresenter(IJokesView iJokesView) {
        this.iJokesView = iJokesView;
        this.jokesModel = new JokesModel();
    }

    public void getJokesData(){
        jokesModel.getData(new JokesModel.JokesModelCallBack() {
            @Override
            public void Succeed(JokesBean jokesBean) {
                if (iJokesView!=null){
                    iJokesView.Succeed(jokesBean);
                }
            }
            @Override
            public void Failure(Exception e) {

            }
        });
    }


}
