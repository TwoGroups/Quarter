package com.erzu.quarter.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.erzu.quarter.R;
import com.erzu.quarter.model.bean.SearchBean;
import com.erzu.quarter.model.bean.SearchHistoryBean;
import com.erzu.quarter.model.bean.SearchInterstedBean;
import com.erzu.quarter.presenter.SearchHistoryPresenter;
import com.erzu.quarter.presenter.SearchInterstedPresenter;
import com.erzu.quarter.presenter.SearchPresenter;
import com.erzu.quarter.view.IView.ISearchHistoryView;
import com.erzu.quarter.view.IView.ISearchInterstedView;
import com.erzu.quarter.view.IView.ISearchView;
import com.erzu.quarter.view.adapter.SearchAdapter;
import com.erzu.quarter.view.adapter.SearchHistoryAdapter;
import com.erzu.quarter.view.adapter.SearchInterstedAdapter;

import java.util.List;

public class SearchActivity extends AppCompatActivity implements ISearchView,ISearchInterstedView,ISearchHistoryView {

    private LinearLayout mBackSearch;
    private ImageView mSearchImageSearch;
    private EditText mSearchTextSearch;
    private TextView mCancelSearch;
    private TextView mClearSearch;
    private RecyclerView mHistorySearch;
    private RecyclerView mInsterstedSearch;
    private SearchHistoryPresenter searchHistoryPresenter;
    private SearchPresenter searchPresenter;
    private SearchInterstedPresenter searchInterstedPresenter;
    private SearchAdapter searchAdapter;
    private SearchInterstedAdapter searchInterstedAdapter;
    private SearchHistoryAdapter searchHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        mBackSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

       //搜索历史
        searchHistoryPresenter = new SearchHistoryPresenter(this);
        searchHistoryPresenter.getSearchHistoryData();
        //搜索
        searchPresenter = new SearchPresenter(this);
        mSearchImageSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(SearchActivity.this, ""+mSearchTextSearch.getText().toString(), Toast.LENGTH_SHORT).show();
                searchPresenter.getSearchData(mSearchTextSearch.getText().toString());
            }
        });

        //感兴趣
        searchInterstedPresenter = new SearchInterstedPresenter(this);
        searchInterstedPresenter.getSearchInterstedData();

        //布局管理器

        mHistorySearch.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mInsterstedSearch.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


        searchAdapter = new SearchAdapter(this);
        searchInterstedAdapter = new SearchInterstedAdapter(this);
        searchHistoryAdapter = new SearchHistoryAdapter(this);

        mClearSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchHistoryAdapter.clear();
                searchHistoryAdapter.notifyDataSetChanged();
                searchAdapter.clear();
                searchAdapter.notifyDataSetChanged();
            }
        });


    }

    private void initView() {
        mBackSearch = (LinearLayout) findViewById(R.id.search_back);
        mSearchImageSearch = (ImageView) findViewById(R.id.search_searchImage);
        mSearchTextSearch = (EditText) findViewById(R.id.search_searchText);
        mCancelSearch = (TextView) findViewById(R.id.search_cancel);
        mClearSearch = (TextView) findViewById(R.id.search_clear);
        mHistorySearch = (RecyclerView) findViewById(R.id.search_history);
        mInsterstedSearch = (RecyclerView) findViewById(R.id.search_instersted);
    }
    @Override
    public void Succeedd(SearchBean searchBean) {
        mHistorySearch.setAdapter(searchAdapter);
        searchAdapter.addData(searchBean.getData());
        searchAdapter.notifyDataSetChanged();
    }

    @Override
    public void Failure(Exception e) {

    }

    @Override
    public void Succeed(SearchBean searchHistoryBean) {
        searchHistoryAdapter.addData(searchHistoryBean.getData());
        mHistorySearch.setAdapter(searchHistoryAdapter);
        searchHistoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void Succeed(SearchInterstedBean searchInterstedBean) {

        searchInterstedAdapter.addData(searchInterstedBean.getData());
        mInsterstedSearch.setAdapter(searchInterstedAdapter);
        searchInterstedAdapter.notifyDataSetChanged();
     }
}
