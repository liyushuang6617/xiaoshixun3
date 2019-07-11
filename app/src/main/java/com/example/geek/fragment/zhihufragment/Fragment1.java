package com.example.geek.fragment.zhihufragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.geek.R;
import com.example.geek.adapter.RlvZhihuF1Adapter;
import com.example.geek.base.BaseMvpFragment;
import com.example.geek.bean.ZhihuRibaoBean;
import com.example.geek.zhuhuribaomvp.ZbM;
import com.example.geek.zhuhuribaomvp.ZbP;
import com.example.geek.zhuhuribaomvp.ZbV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends BaseMvpFragment<ZbP, ZbV, ZbM> implements ZbV {

    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    @BindView(R.id.fbt)
    FloatingActionButton fbt;
    Unbinder unbinder1;
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

    @OnClick(R.id.fbt)
    public void onViewClicked() {
        Toast.makeText(getActivity(), "123悬浮按钮", Toast.LENGTH_SHORT).show();
    }
}
