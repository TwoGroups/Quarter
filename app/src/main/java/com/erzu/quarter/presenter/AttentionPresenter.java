package com.erzu.quarter.presenter;

import com.erzu.quarter.model.bean.AttentionBean;
import com.erzu.quarter.model.http.AttentionModel;
import com.erzu.quarter.view.IView.IMyAttentionView;

/**
 * Created by 超Sir on 2018/2/3.
 */

public class AttentionPresenter {
    private IMyAttentionView myAttentionView;
    private AttentionModel attentionModel;

    public AttentionPresenter(IMyAttentionView myAttentionView) {
        this.myAttentionView = myAttentionView;
        this.attentionModel = new AttentionModel();
    }


    public void getAttentionData(int uid, String token) {


        attentionModel.getData(uid, token, new AttentionModel.AttentionModelCallBack() {
            @Override
            public void Succeed(AttentionBean attentionBean) {
                myAttentionView.Succeed(attentionBean);
            }

            @Override
            public void Failure(Exception e) {
                myAttentionView.Failure(e);
            }
        });

    }

    //防止内存泄漏
    public void detach() {
        myAttentionView = null;
    }
}
