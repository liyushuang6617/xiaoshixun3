package com.example.date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.date.adapter.RlvAdapter;
import com.example.date.base.BaseMvpActivity;
import com.example.date.bean.DateBean;
import com.example.date.bean.DayNewsBean;
import com.example.date.ribaomvp.DateM;
import com.example.date.ribaomvp.DateP;
import com.example.date.ribaomvp.DateV;
import com.example.date.utils.DateUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//李玉爽  1811A
public class MainActivity extends BaseMvpActivity<DateP, DateV, DateM> implements DateV {

    @BindView(R.id.re)
    RecyclerView re;
    @BindView(R.id.flbt)
    FloatingActionButton flbt;
    private ArrayList<DateBean.StoriesBean> list;
    private ArrayList<DayNewsBean.StoriesBean> artlist;
    private ArrayList<DayNewsBean.TopStoriesBean> banlist;
    private RlvAdapter adapter;

    private String date;
    boolean isBefore;
    BroadcastReceiver myBroadCastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            date = intent.getStringExtra("date");
            String yyyymmdd = DateUtils.getYYYYMMDD();
            if (date.equals(yyyymmdd)) {
                isBefore = false;
                adapter.setBefore(isBefore, date);
                myPresenter.getDayNews();
            } else {
                isBefore = true;
                adapter.setBefore(isBefore, date);
                myPresenter.getDate(date);
            }
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected DateM initMvpModel() {
        return new DateM();
    }

    @Override
    protected DateV initMvpView() {
        return this;
    }

    @Override
    protected DateP initMvpPresneter() {
        return new DateP();
    }

    @Override
    protected void initView() {
        super.initView();
        initBroadcastManager();

        list = new ArrayList<>();
        artlist = new ArrayList<>();
        banlist = new ArrayList<>();
        adapter = new RlvAdapter(this, list, artlist, banlist);
        re.setAdapter(adapter);
        re.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initBroadcastManager() {
        IntentFilter intentFilter = new IntentFilter("com.geekdemo.date");

        LocalBroadcastManager.getInstance(this).registerReceiver(myBroadCastReceiver, intentFilter);
    }

    @Override
    protected void initData() {
        super.initData();
        myPresenter.getDayNews();
        myPresenter.getDate(date);
    }

    @Override
    public void onDayNewsSuccess(DayNewsBean dayNewsBean) {
        artlist.addAll(dayNewsBean.getStories());
        banlist.addAll(dayNewsBean.getTop_stories());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDateonSuccess(DateBean dateBean) {
        list.addAll(dateBean.getStories());
        adapter.notifyDataSetChanged();
    }

    private static final String TAG = "MainActivity";

    @Override
    public void onFail(String msg) {
        Log.e(TAG, "onFail: " + msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myBroadCastReceiver);
    }

    @OnClick(R.id.flbt)
    public void onViewClicked() {
        startActivity(new Intent(MainActivity.this, CalenderActivity.class));
    }
}
