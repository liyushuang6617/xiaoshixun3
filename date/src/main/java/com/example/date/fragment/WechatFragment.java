package com.example.date.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.date.R;
import com.example.date.adapter.RlvWechatAdapter;
import com.example.date.base.BaseMvpFragment;
import com.example.date.bean.WechatBean;
import com.example.date.wechatmvp.WechatM;
import com.example.date.wechatmvp.WechatP;
import com.example.date.wechatmvp.WechatV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WechatFragment extends BaseMvpFragment<WechatP, WechatV, WechatM> implements WechatV {

    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private ArrayList<WechatBean.NewslistBean> list;
    private RlvWechatAdapter adapter;

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_wechat;
    }

    @Override
    protected WechatM initMvpModel() {
        return new WechatM();
    }

    @Override
    protected WechatV initMvpView() {
        return this;
    }

    @Override
    protected WechatP initMvpPresneter() {
        return new WechatP();
    }

    @Override
    protected void initView() {
        super.initView();
        list = new ArrayList<>();
        adapter = new RlvWechatAdapter(getActivity(), list);
        re.setAdapter(adapter);
        re.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void initData() {
        super.initData();
        myPresenter.getData();
    }

    @Override
    public void onSuccess(WechatBean wechatBean) {
        list.addAll(wechatBean.getNewslist());
        adapter.notifyDataSetChanged();
    }

    private static final String TAG = "WechatFragment";
    @Override
    public void onFail(String msg) {
        Log.e(TAG, "onFail: " +msg );
    }
}
