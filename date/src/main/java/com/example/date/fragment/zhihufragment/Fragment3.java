package com.example.date.fragment.zhihufragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.date.R;
import com.example.date.adapter.RlvHotAdapter;
import com.example.date.base.BaseMvpFragment;
import com.example.date.bean.HotBean;
import com.example.date.zhuhuhotmvp.HotM;
import com.example.date.zhuhuhotmvp.HotP;
import com.example.date.zhuhuhotmvp.HotV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends BaseMvpFragment<HotP, HotV, HotM> implements HotV {

    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private ArrayList<HotBean.RecentBean> list;
    private RlvHotAdapter adapter;

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_fragment3;
    }

    @Override
    protected HotM initMvpModel() {
        return new HotM();
    }

    @Override
    protected HotV initMvpView() {
        return this;
    }

    @Override
    protected HotP initMvpPresneter() {
        return new HotP();
    }

    @Override
    protected void initView() {
        super.initView();
        list = new ArrayList<>();
        adapter = new RlvHotAdapter(getActivity(), list);
        re.setAdapter(adapter);
        re.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void initData() {
        super.initData();
        myPresenter.getData();
    }

    @Override
    public void onSuccess(HotBean hotBean) {
        list.addAll(hotBean.getRecent());
        adapter.notifyDataSetChanged();
    }

    private static final String TAG = "Fragment3";

    @Override
    public void onFail(String msg) {
        Log.e(TAG, "onFail: " + msg);
    }
}
