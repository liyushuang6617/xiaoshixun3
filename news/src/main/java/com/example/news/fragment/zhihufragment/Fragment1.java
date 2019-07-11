package com.example.news.fragment.zhihufragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.news.R;
import com.example.news.adapter.RlvRbAdapter;
import com.example.news.base.BaseMvpFragment;
import com.example.news.bean.RiBaoBean;
import com.example.news.ribaomvp.RbM;
import com.example.news.ribaomvp.RbP;
import com.example.news.ribaomvp.RbV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends BaseMvpFragment<RbP, RbV, RbM> implements RbV {

    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private ArrayList<RiBaoBean.StoriesBean> banlist;
    private ArrayList<RiBaoBean.TopStoriesBean> artlist;
    private RlvRbAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fragment1;
    }

    @Override
    protected RbM initMvpModel() {
        return new RbM();
    }

    @Override
    protected RbV initMvpView() {
        return this;
    }

    @Override
    protected RbP initMvpPresenter() {
        return new RbP();
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        banlist = new ArrayList<>();
        artlist = new ArrayList<>();
        adapter = new RlvRbAdapter(getActivity(), banlist, artlist);
        re.setAdapter(adapter);
        re.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getData();
    }

    @Override
    public void onSuccess(RiBaoBean riBaoBean) {
        banlist.addAll(riBaoBean.getStories());
        artlist.addAll(riBaoBean.getTop_stories());
        adapter.notifyDataSetChanged();
    }

    private static final String TAG = "Fragment1";

    @Override
    public void onFail(String msg) {
        Log.e(TAG, "onFail: " + msg);
    }
}
