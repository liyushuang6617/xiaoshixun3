package com.example.num2.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.num2.R;
import com.example.num2.adapter.VpZhihuAdapter;
import com.example.num2.base.BaseFragment;
import com.example.num2.fragment.zhihufragment.Fragment1;
import com.example.num2.fragment.zhihufragment.Fragment2;
import com.example.num2.fragment.zhihufragment.Fragment3;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuNewDaysFragment extends BaseFragment {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
    private ArrayList<Fragment> list;
    private ArrayList<String> title;
    private VpZhihuAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu_new_days;
    }

    @Override
    protected void initView() {
        super.initView();
        list = new ArrayList<>();
        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());
        list.add(new Fragment3());

        title = new ArrayList<>();
        title.add("日报");
        title.add("主题");
        title.add("专栏");
        title.add("热门");

        adapter = new VpZhihuAdapter(getChildFragmentManager(), list, title);
        vp.setAdapter(adapter);

        tab.setupWithViewPager(vp);
    }
}
