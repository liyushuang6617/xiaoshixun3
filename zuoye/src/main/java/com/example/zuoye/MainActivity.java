package com.example.zuoye;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.zuoye.adapter.VpMyAdapter;
import com.example.zuoye.fragment.Fragment1;
import com.example.zuoye.fragment.Fragment2;

import java.util.ArrayList;

//李玉爽  1811A
public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> list;
    private ArrayList<String> title;
    private VpMyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);

        mToolbar.setTitle("商业财经");

        list = new ArrayList<>();
        list.add(new Fragment1());
        list.add(new Fragment2());

        title = new ArrayList<>();
        title.add("最新");
        title.add("商业财经");

        adapter = new VpMyAdapter(getSupportFragmentManager(), list, title);
        mVp.setAdapter(adapter);

        mTab.setupWithViewPager(mVp);
    }
}
