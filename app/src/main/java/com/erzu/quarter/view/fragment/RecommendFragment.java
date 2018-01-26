package com.erzu.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erzu.quarter.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 推荐页面
 * Created by hp on 2018/1/19.
 */

public class RecommendFragment extends Fragment {
    @BindView(R.id.tab_FindFragment_title)
    TabLayout tabFindFragmentTitle;
    @BindView(R.id.vp_FindFragment_pager)
    ViewPager vpFindFragmentPager;
    Unbinder unbinder;
    List<Fragment> frag_list;
    List<String> title_list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_recommend, null);
        unbinder = ButterKnife.bind(this, view);
        fragmentadd();
        return view;
    }

    private void fragmentadd() {
        frag_list = new ArrayList<>();
        frag_list.add(new GreatFragment());
        frag_list.add(new FollowFragment());
        title_list = new ArrayList<>();
        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        title_list.add("热门");
        title_list.add("关注");
        //设置TabLayout的模式
        tabFindFragmentTitle.setTabMode(TabLayout.MODE_FIXED);
//        tabFindFragmentTitle.addTab(tabFindFragmentTitle.newTab().setText(title_list.get(0)));
//        tabFindFragmentTitle.addTab(tabFindFragmentTitle.newTab().setText(title_list.get(1)));
        Viewpager viewpager = new Viewpager(getActivity().getSupportFragmentManager());
        vpFindFragmentPager.setAdapter(viewpager);
        /**
         * TabLayout与Viewpager关联
         */
        tabFindFragmentTitle.setupWithViewPager(vpFindFragmentPager);
    }
    /**
     * ViewPager适配器
     */
    public class Viewpager extends FragmentPagerAdapter {
        public Viewpager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return frag_list.get(position);
        }

        @Override
        public int getCount() {
            return title_list.size();
        }

        //此方法用来显示tab上的名字
        @Override
        public CharSequence getPageTitle(int position) {

            return title_list.get(position % title_list.size());
        }

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
