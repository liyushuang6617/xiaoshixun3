package com.example.date;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.example.date.base.BaseActivity;
import com.example.date.fragment.WechatFragment;
import com.example.date.fragment.ZhihuDayNewsFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//李玉爽 1811A
public class Main2Activity extends BaseActivity {

    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.fl)
    FrameLayout fl;
    private ArrayList<Fragment> list;
    private FragmentManager manager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initView() {
        super.initView();
        tab.addTab(tab.newTab().setText("日报"));
        tab.addTab(tab.newTab().setText("微信"));

        list = new ArrayList<>();
        list.add(new ZhihuDayNewsFragment());
        list.add(new WechatFragment());

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fl, list.get(0));
        transaction.commit();

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        switchFragment(0);
                        break;
                    case 1:
                        switchFragment(1);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private int last;

    private void switchFragment(int type) {
        Fragment fragment = list.get(type);
        Fragment lastFragment = list.get(last);
        FragmentTransaction transaction = manager.beginTransaction();
        if (!fragment.isAdded()) {
            transaction.add(R.id.fl, fragment);
        }
        transaction.show(fragment);
        transaction.hide(lastFragment);
        transaction.commit();
        last = type;

    }
}
