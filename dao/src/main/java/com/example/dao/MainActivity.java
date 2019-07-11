package com.example.dao;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.dao.fragment.Fragment1;
import com.example.dao.fragment.Fragment2;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private FrameLayout mFl;
    private ArrayList<Fragment> list;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mFl = (FrameLayout) findViewById(R.id.fl);

        list = new ArrayList<>();
        list.add(new Fragment1());
        list.add(new Fragment2());

        mTab.addTab(mTab.newTab().setText("A"));
        mTab.addTab(mTab.newTab().setText("B"));

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fl, list.get(0));
        transaction.commit();

        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
