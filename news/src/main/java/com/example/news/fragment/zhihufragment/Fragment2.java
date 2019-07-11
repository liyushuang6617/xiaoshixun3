package com.example.news.fragment.zhihufragment;


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

import com.example.news.CalenderActivity;
import com.example.news.R;
import com.example.news.adapter.RlvDataAdapter;
import com.example.news.base.BaseMvpFragment;
import com.example.news.bean.DataBean;
import com.example.news.bean.RiBaoBean;
import com.example.news.datemvp.DateM;
import com.example.news.datemvp.DateP;
import com.example.news.datemvp.DateV;
import com.example.news.utils.DateUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends BaseMvpFragment<DateP, DateV, DateM> implements DateV {

    private static final String TAG = "Fragment2";
    @BindView(R.id.re)
    RecyclerView re;
    @BindView(R.id.flbt)
    FloatingActionButton flbt;
    Unbinder unbinder;
    Unbinder unbinder1;
    private ArrayList<DataBean.StoriesBean> list;
    private ArrayList<RiBaoBean.TopStoriesBean> banlist;
    private ArrayList<RiBaoBean.StoriesBean> artlist;
    private RlvDataAdapter adapter;

    boolean isBefore;
    BroadcastReceiver myBroadCastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            date = intent.getStringExtra("date");
// TODO 是否是当天
            String yyyymmdd = DateUtils.getYYYYMMDD();
            if (date.equals(yyyymmdd)) {
                isBefore = false;
                adapter.setIsBefore(isBefore, "今日新闻");

                mPresenter.getData1();
            } else {
                isBefore = true;
                adapter.setIsBefore(isBefore, date);
                mPresenter.getData(date);
            }


            Log.d(TAG, "onReceive: 日期为=" + date + "---" + isBefore);

        }
    };
    private String date;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fragment2;
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
    protected DateP initMvpPresenter() {
        return new DateP();
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);

        initBroadcastManager();
        list = new ArrayList<>();
        artlist = new ArrayList<>();
        banlist = new ArrayList<>();
        adapter = new RlvDataAdapter(getActivity(), list, artlist, banlist);
        re.setAdapter(adapter);
        re.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void initBroadcastManager() {
        IntentFilter intentFilter = new IntentFilter("com.news.date");

        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(myBroadCastReceiver, intentFilter);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getData(date);
        mPresenter.getData1();
    }

    @Override
    public void onSuccess(DataBean dataBean) {
        adapter.refreshDate(dataBean.getDate());
        list.addAll(dataBean.getStories());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccess1(RiBaoBean riBaoBean) {
        artlist.addAll(riBaoBean.getStories());
        banlist.addAll(riBaoBean.getTop_stories());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unRegisterBroadcast();
            unbinder.unbind();

        }
    }

    public void unRegisterBroadcast() {
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(myBroadCastReceiver);
    }

    @OnClick(R.id.flbt)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), CalenderActivity.class));
    }
}
