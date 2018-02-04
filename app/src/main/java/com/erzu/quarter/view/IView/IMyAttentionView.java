package com.erzu.quarter.view.IView;

import com.erzu.quarter.model.bean.AttentionBean;
import com.erzu.quarter.model.bean.JokesBean;

/**
 * Created by 超Sir on 2018/2/3.
 */

public interface IMyAttentionView {

    void Succeed(AttentionBean attentionBean);
    void Failure(Exception e);

}
