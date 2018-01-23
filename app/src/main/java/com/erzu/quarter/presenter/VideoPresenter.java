package com.erzu.quarter.presenter;

import com.erzu.quarter.model.bean.VideoRecommendBean;
import com.erzu.quarter.utils.HttpUtils;
import com.erzu.quarter.view.IMainView;

/**
 * Created by caojun on 2017/12/26.
 */

public class VideoPresenter extends BasePresenter implements HttpUtils.HttpUtilsCallback<VideoRecommendBean> {

    private IMainView iBaseView;
    private boolean needClear = false;
    private int page;
    private HttpUtils httpUtils;

    public VideoPresenter() {
        httpUtils = new HttpUtils();
    }

    public void loadDataFromServer() {
        httpUtils.loadData(this, "1", 1, VideoRecommendBean.class);
    }

    public void attachView(IMainView view) {
        //IMainView view = MainActivity
        this.iBaseView = view;
    }

    public void dettachView() {
        iBaseView = null;
    }


    @Override
    public void callbackOK(VideoRecommendBean testBean) {
        //做逻辑判断 回调数据
        iBaseView.onSuccess(testBean);
        needClear = false;
    }

    @Override
    public void callbackErr(String errMessage) {

    }

    public void refreshData() {
        needClear = true;
        page = 0;
        httpUtils.loadData(this, "1", page, VideoRecommendBean.class);
    }

    public void loadMore() {
        page++;
        httpUtils.loadData(this, "1", page, VideoRecommendBean.class);
    }
}
