package com.erzu.quarter.presenter;

import com.erzu.quarter.model.bean.JokesBean;
import com.erzu.quarter.model.bean.SearchBean;
import com.erzu.quarter.model.http.JokesModel;
import com.erzu.quarter.model.http.SearchModel;
import com.erzu.quarter.view.IView.IJokesView;
import com.erzu.quarter.view.IView.ISearchView;

/**
 *
 */

public class SearchPresenter {

    private ISearchView iSearchView;
    private SearchModel searchModel;

    public SearchPresenter(ISearchView iSearchView) {
        this.iSearchView = iSearchView;
        this.searchModel = new SearchModel();
    }

    public void getSearchData(String keyWords){

        searchModel.search(keyWords,new SearchModel.SearchModelCallBack() {
            @Override
            public void onSuccess(SearchBean searchBean) {

                    iSearchView.Succeed(searchBean);
                //System.out.println("searchBean"+searchBean);
            }

            @Override
            public void Failure(Exception e) {
          iSearchView.Failure(e);
            }
        });
    }


}
