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
import com.example.news.adapter.RlvRemenAdapter;
import com.example.news.base.BaseMvpFragment;
import com.example.news.bean.RemenBean;
import com.example.news.remenmvp.RemM;
import com.example.news.remenmvp.RemP;
import com.example.news.remenmvp.RemV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment4 extends BaseMvpFragment<RemP, RemV, RemM> implements RemV {

    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private ArrayList<RemenBean.RecentBean> list;
    private RlvRemenAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_fragment4;
    }

    @Override
    protected RemM initMvpModel() {
        return new RemM();
    }

    @Override
    protected RemV initMvpView() {
        return this;
    }

    @Override
    protected RemP initMvpPresenter() {
        return new RemP();
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        list = new ArrayList<>();
        adapter = new RlvRemenAdapter(getActivity(), list);
        re.setAdapter(adapter);
        re.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getData();
    }

    @Override
    public void onSuccess(RemenBean remenBean) {
        list.addAll(remenBean.getRecent());
        adapter.notifyDataSetChanged();
    }

    private static final String TAG = "Fragment4";
    @Override
    public void onFail(String msg) {
        Log.e(TAG, "onFail: " +msg);
    }
}
