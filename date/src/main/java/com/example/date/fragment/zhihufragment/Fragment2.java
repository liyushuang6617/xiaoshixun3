package com.example.date.fragment.zhihufragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.date.R;
import com.example.date.adapter.RlvZhihuF1Adapter;
import com.example.date.adapter.RlvZhuanLanAdapter;
import com.example.date.base.BaseMvpFragment;
import com.example.date.bean.ZhuanLanBean;
import com.example.date.zhihuf2mvp.ZhuanLM;
import com.example.date.zhihuf2mvp.ZhuanlP;
import com.example.date.zhihuf2mvp.ZhuanlV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends BaseMvpFragment<ZhuanlP, ZhuanlV, ZhuanLM> implements ZhuanlV {

    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private ArrayList<ZhuanLanBean.DataBean> list;
    private RlvZhuanLanAdapter adapter;

    @Override
    protected int getlayoutId() {
        return R.layout.fragment_fragment2;
    }

    @Override
    protected ZhuanLM initMvpModel() {
        return new ZhuanLM();
    }

    @Override
    protected ZhuanlV initMvpView() {
        return this;
    }

    @Override
    protected ZhuanlP initMvpPresneter() {
        return new ZhuanlP();
    }

    @Override
    protected void initView() {
        super.initView();
        list = new ArrayList<>();
        adapter = new RlvZhuanLanAdapter(getActivity(), list);
        re.setAdapter(adapter);
        re.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }

    @Override
    protected void initData() {
        super.initData();
        myPresenter.getData();
    }

    @Override
    public void onSuucess(ZhuanLanBean zhuanLanBean) {
        list.addAll(zhuanLanBean.getData());
        adapter.notifyDataSetChanged();
    }

    private static final String TAG = "Fragment2";

    @Override
    public void onFail(String msg) {
        Log.e(TAG, "onFail: " + msg);
    }
}
