package com.example.work;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.work.adapter.VpMyAdapter;
import com.example.work.tabfragment.Fragment1;
import com.example.work.tabfragment.Fragment2;

import java.util.ArrayList;

//李玉爽 1811A
public class Main3Activity extends AppCompatActivity {

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
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);

        list = new ArrayList<>();
        list.add(new Fragment1());
        list.add(new Fragment2());

        title = new ArrayList<>();
        title.add("首页");
        title.add("收藏");

        adapter = new VpMyAdapter(getSupportFragmentManager(), list, title);
        mVp.setAdapter(adapter);

        mTab.setupWithViewPager(mVp);
    }
}
