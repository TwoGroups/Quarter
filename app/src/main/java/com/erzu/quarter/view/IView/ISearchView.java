package com.erzu.quarter.view.IView;

import com.erzu.quarter.model.bean.SearchBean;
import com.erzu.quarter.model.bean.SearchHistoryBean;

/**
 * Created by War on 2018/1/23.
 */

public interface ISearchView {

    void Succeed(SearchBean searchBean);
    void Failure(Exception e);

}
