package com.example.num3.fragment.zhihufragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.num3.R;
import com.example.num3.adapter.RlvZhihuF1Adapter;
import com.example.num3.base.BaseMvpFragment;
import com.example.num3.bean.ZhihuRibaoBean;
import com.example.num3.zhuhuribaomvp.ZbM;
import com.example.num3.zhuhuribaomvp.ZbP;
import com.example.num3.zhuhuribaomvp.ZbV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends BaseMvpFragment<ZbP, ZbV, ZbM> implements ZbV {

    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private ArrayList<ZhihuRibaoBean.StoriesBean> banlist;
    private ArrayList<ZhihuRibaoBean.TopStoriesBean> artlist;
    private RlvZhihuF1Adapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fragment1;
    }

    @Override
    protected ZbM initMvpModel() {
        return new ZbM();
    }

    @Override
    protected ZbV initMvpView() {
        return this;
    }

    @Override
    protected ZbP initMvpPresenter() {
        return new ZbP();
    }

    @Override
    protected void initView() {
        super.initView();
        banlist = new ArrayList<>();
        artlist = new ArrayList<>();
        adapter = new RlvZhihuF1Adapter(getContext(), banlist, artlist);
        re.setAdapter(adapter);
        re.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getData();
    }

    @Override
    public void onSuccess(ZhihuRibaoBean zhihuRibaoBean) {
        banlist.addAll(zhihuRibaoBean.getStories());
        artlist.addAll(zhihuRibaoBean.getTop_stories());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {

    }
}

