package com.erzu.quarter.presenter;

import com.erzu.quarter.model.bean.CollectBean;
import com.erzu.quarter.model.http.CollectModel;
import com.erzu.quarter.view.IView.ICollectView;

/**
 * Created by hp on 2018/2/4.
 */

public class CollectPresenter {
    private ICollectView iCollectView;
    private CollectModel collectModel;

    public CollectPresenter(ICollectView iCollectView) {
        this.iCollectView = iCollectView;
        this.collectModel = new CollectModel();
    }

    public void CollectGetData(int uid, String token) {
        collectModel.Collect(uid, token, new CollectModel.CollectCallBack() {
            @Override
            public void Succeed(CollectBean collectBean) {
                if (iCollectView != null) {
                    iCollectView.onSucceed(collectBean);
                }
            }

            @Override
            public void Failure(Exception e) {

            }
        });
    }
}
