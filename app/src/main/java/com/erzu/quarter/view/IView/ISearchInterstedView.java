package com.erzu.quarter.view.IView;

import com.erzu.quarter.model.bean.SearchBean;
import com.erzu.quarter.model.bean.SearchHistoryBean;
import com.erzu.quarter.model.bean.SearchInterstedBean;

/**
 * Created by War on 2018/1/23.
 */

public interface ISearchInterstedView {

    void Succeed(SearchInterstedBean searchBean);
    void Failure(Exception e);

}
