package com.erzu.quarter.presenter;

import com.erzu.quarter.model.bean.WriteJokeBean;
import com.erzu.quarter.model.http.PublishModel;
import com.erzu.quarter.view.IView.IPublishView;

/**
 * Created by War on 2018/2/4.
 */

public class PublishPresenter {
    private IPublishView publishView;
    private PublishModel publishModel;

    public PublishPresenter(IPublishView publishView) {
        this.publishView = publishView;
        this.publishModel = new PublishModel();
    }

    public void putJokesData(String joke, String uid, String token) {
        publishModel.getData(joke, uid, token, new PublishModel.PublishModelCallBack() {

            @Override
            public void Succeed(WriteJokeBean jokesBean) {
                if (publishView != null) {
                    publishView.Succeed(jokesBean);
                }
            }

            @Override
            public void Failure(Exception e) {

            }
        });
    }

}
