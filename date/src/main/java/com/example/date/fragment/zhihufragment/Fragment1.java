package com.example.date.fragment.zhihufragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.date.CalenderActivity;
import com.example.date.R;
import com.example.date.adapter.RlvZhihuF1Adapter;
import com.example.date.base.BaseMvpFragment;
import com.example.date.bean.DateBean;
import com.example.date.bean.DayNewsBean;
import com.example.date.utils.DateUtils;
import com.example.date.zhuhuf1mvp.DayNewsM;
import com.example.date.zhuhuf1mvp.DayNewsP;
import com.example.date.zhuhuf1mvp.DayNewsV;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends BaseMvpFragment<DayNewsP, DayNewsV, DayNewsM> implements DayNewsV {

    @BindView(R.id.re)
    RecyclerView re;
    @BindView(R.id.flbt)
    FloatingActionButton flbt;
    Unbinder unbinder;
    private ArrayList<DateBean.StoriesBean> list;
    private ArrayList<DayNewsBean.StoriesBean> artlist;
    private ArrayList<DayNewsBean.TopStoriesBean> banlist;
    private RlvZhihuF1Adapter adapter;
    private String date;

    BroadcastReceiver myBroadCastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            date = intent.getStringExtra("date");
            String yyyymmdd = DateUtils.getYYYYMMDD();
            if (date.equals(yyyymmdd)) {
                adapter.setIsbefore(false, "今日热闻");
                myPresenter.getDayNews();
                adapter.notifyDataSetChanged();
            } else {
                adapter.setIsbefore(true, date);
                myPresenter.getDate(date);
                adapter.notifyDataSetChanged();
            }
        }
    };

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_fragment1;
    }

    @Override
    protected DayNewsM initMvpModel() {
        return new DayNewsM();
    }

    @Override
    protected DayNewsV initMvpView() {
        return this;
    }

    @Override
    protected DayNewsP initMvpPresneter() {
        return new DayNewsP();
    }

    @Override
    protected void initView() {
        super.initView();
        initBroadcastManager();

        list = new ArrayList<>();
        artlist = new ArrayList<>();
        banlist = new ArrayList<>();
        adapter = new RlvZhihuF1Adapter(getActivity(), list, artlist, banlist);
        re.setAdapter(adapter);
        re.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void initBroadcastManager() {
        IntentFilter intentFilter = new IntentFilter("com.geekdemo.date");

        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(myBroadCastReceiver, intentFilter);
    }

    @Override
    protected void initData() {
        super.initData();
        myPresenter.getDate(date);
        myPresenter.getDayNews();
    }

    @OnClick(R.id.flbt)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), CalenderActivity.class));
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

    private static final String TAG = "Fragment1";

    @Override
    public void onFail(String msg) {
        Log.e(TAG, "onFail: " + msg);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(myBroadCastReceiver);
    }
}
