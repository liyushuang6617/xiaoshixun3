package com.example.news.fragment.zhihufragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.news.R;
import com.example.news.adapter.RlvZhuanlanAdapter;
import com.example.news.base.BaseMvpFragment;
import com.example.news.bean.ZhuanLanBean;
import com.example.news.zhuanlanmvp.ZlM;
import com.example.news.zhuanlanmvp.ZlP;
import com.example.news.zhuanlanmvp.ZlV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends BaseMvpFragment<ZlP, ZlV, ZlM> implements ZlV {

    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private ArrayList<ZhuanLanBean.DataBean> list;
    private RlvZhuanlanAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fragment3;
    }

    @Override
    protected ZlM initMvpModel() {
        return new ZlM();
    }

    @Override
    protected ZlV initMvpView() {
        return this;
    }

    @Override
    protected ZlP initMvpPresenter() {
        return new ZlP();
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        list = new ArrayList<>();
        adapter = new RlvZhuanlanAdapter(getActivity(), list);
        re.setAdapter(adapter);
        re.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getData();
    }

    @Override
    public void onSuccess(ZhuanLanBean zhuanLanBean) {
        list.addAll(zhuanLanBean.getData());
        adapter.notifyDataSetChanged();
    }

    private static final String TAG = "Fragment3";
    @Override
    public void onFail(String msg) {
        Log.e(TAG, "onFail: " +msg);
    }
}
