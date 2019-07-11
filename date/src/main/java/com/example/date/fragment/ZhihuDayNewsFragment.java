package com.example.date.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.date.R;
import com.example.date.adapter.VpZhihuAdapter;
import com.example.date.base.BaseFragment;
import com.example.date.fragment.zhihufragment.Fragment1;
import com.example.date.fragment.zhihufragment.Fragment2;
import com.example.date.fragment.zhihufragment.Fragment3;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuDayNewsFragment extends BaseFragment {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
    private ArrayList<Fragment> list;
    private ArrayList<String> title;
    private VpZhihuAdapter adapter;

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_zhihu_day_news;
    }

    @Override
    protected void initView() {
        super.initView();
        list = new ArrayList<>();
        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());

        title = new ArrayList<>();
        title.add("最新");
        title.add("专栏");
        title.add("热门");

        adapter = new VpZhihuAdapter(getChildFragmentManager(), list, title);
        vp.setAdapter(adapter);

        tab.setupWithViewPager(vp);
    }
}
