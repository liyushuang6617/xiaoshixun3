package com.example.num2.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.num2.R;
import com.example.num2.adapter.RlvWechatAdapter;
import com.example.num2.base.BaseMvpFragment;
import com.example.num2.bean.WechatBean;
import com.example.num2.wechatmvp.WeM;
import com.example.num2.wechatmvp.WeP;
import com.example.num2.wechatmvp.WeV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WechatFragment extends BaseMvpFragment<WeP, WeV, WeM> implements WeV {

    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private ArrayList<WechatBean.NewslistBean> list;
    private RlvWechatAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wechat;
    }

    @Override
    protected WeM initMvpModel() {
        return new WeM();
    }

    @Override
    protected WeV initMvpView() {
        return this;
    }

    @Override
    protected WeP initMvpPresenter() {
        return new WeP();
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
        mPresenter.getData();
    }

    @Override
    public void onSuccess(WechatBean wechatBean) {
        list.addAll(wechatBean.getNewslist());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {

    }

}
