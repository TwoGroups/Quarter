package com.erzu.quarter.presenter;

import android.content.Context;

import com.erzu.quarter.model.bean.SearchHistoryBean;
import com.erzu.quarter.model.bean.SearchInterstedBean;
import com.erzu.quarter.model.http.HistoryModel;
import com.erzu.quarter.model.http.InterstedModel;
import com.erzu.quarter.view.IView.ISearchHistoryView;
import com.erzu.quarter.view.IView.ISearchInterstedView;
import com.erzu.quarter.view.activity.SearchActivity;

import java.util.List;

/**
 * 
 */

public class SearchInterstedPresenter {

    private ISearchInterstedView iSearchInterstedView;
    private InterstedModel interstedModel;

    public SearchInterstedPresenter(ISearchInterstedView iSearchInterstedView) {
        this.iSearchInterstedView = iSearchInterstedView;
        this.interstedModel = new InterstedModel();
    }

    public void getSearchInterstedData(){

         interstedModel.searchIntersted(new InterstedModel.SearchInterstedModelCallBack() {
             @Override
             public void onSuccess(SearchInterstedBean interstedBean) {
                 iSearchInterstedView.Succeed(interstedBean);
             }

             @Override
             public void Failure(Exception e) {
                  iSearchInterstedView.Failure(e);
             }
         });
    }


}
