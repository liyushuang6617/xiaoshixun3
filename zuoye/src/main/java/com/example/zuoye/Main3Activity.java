package com.example.zuoye;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.zuoye.adapter.VpMyAdapter;
import com.example.zuoye.fragment.Fragment3;

import java.util.ArrayList;

import cn.jzvd.JZVideoPlayerStandard;

public class Main3Activity extends AppCompatActivity {

    private JZVideoPlayerStandard mJz;
    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> list;
    private ArrayList<String> title;
    private VpMyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        mJz = (JZVideoPlayerStandard) findViewById(R.id.jz);
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);

        list = new ArrayList<>();
        list.add(new Fragment3());
        list.add(new Fragment3());
        list.add(new Fragment3());

        title = new ArrayList<>();
        title.add("介绍");
        title.add("目录");
        title.add("评价");

        adapter = new VpMyAdapter(getSupportFragmentManager(), list, title);
        mVp.setAdapter(adapter);

        mTab.setupWithViewPager(mVp);

    }
}
