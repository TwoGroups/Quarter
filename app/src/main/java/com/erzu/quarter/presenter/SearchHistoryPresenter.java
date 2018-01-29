package com.erzu.quarter.presenter;

import com.erzu.quarter.model.bean.SearchBean;
import com.erzu.quarter.model.bean.SearchHistoryBean;
import com.erzu.quarter.model.http.HistoryModel;
import com.erzu.quarter.model.http.SearchModel;
import com.erzu.quarter.view.IView.ISearchHistoryView;
import com.erzu.quarter.view.IView.ISearchView;

/**
 * 
 */

public class SearchHistoryPresenter {

    private ISearchHistoryView iSearchHistoryView;
    private HistoryModel historyModel;

    public SearchHistoryPresenter(ISearchHistoryView iSearchHistoryView) {
        this.iSearchHistoryView = iSearchHistoryView;
        this.historyModel = new HistoryModel();
    }

    public void getSearchHistoryData(){

        historyModel.searchHistory(new HistoryModel.SearchHistoryModelCallBack() {
            @Override
            public void onSuccess(SearchHistoryBean historyBean) {
                iSearchHistoryView.Succeed(historyBean);
            }

            @Override
            public void Failure(Exception e) {
                iSearchHistoryView.Failure(e);
            }
        });
    }


}
