package com.example.geek.fragment.ganfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.geek.R;
import com.example.geek.adapter.RlvGankAdapter;
import com.example.geek.base.BaseMvpFragment;
import com.example.geek.bean.GankBean;
import com.example.geek.gankcommommvp.GankCommonM;
import com.example.geek.gankcommommvp.GankCommonP;
import com.example.geek.gankcommommvp.GankCommonV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GankCommonFragment extends BaseMvpFragment<GankCommonP, GankCommonV, GankCommonM> implements GankCommonV {

    @BindView(R.id.iv_tech_blur)
    ImageView ivTechBlur;
    @BindView(R.id.tv_tech_copyright)
    TextView tvTechCopyright;
    @BindView(R.id.re)
    RecyclerView re;
    Unbinder unbinder;
    private String key;
    private ArrayList<GankBean.ResultsBean> list;
    private RlvGankAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank_common;
    }

    @Override
    protected GankCommonM initMvpModel() {
        return new GankCommonM();
    }

    @Override
    protected GankCommonV initMvpView() {
        return this;
    }

    @Override
    protected GankCommonP initMvpPresenter() {
        return new GankCommonP();
    }

    @Override
    protected void initView() {
        super.initView();

        Glide.with(getActivity())
                .load("https://ww1.sinaimg.cn/large/0065oQSqly1g2hekfwnd7j30sg0x4djy.jpg")
                .into(ivTechBlur);

        tvTechCopyright.setText("翠花");

        Bundle arguments = getArguments();
        key = arguments.getString("fragment");

        list = new ArrayList<>();
        adapter = new RlvGankAdapter(getActivity(), list);
        re.setAdapter(adapter);
        re.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getData(key);
    }

    @Override
    public void onSuccess(GankBean gankBean) {
        list.addAll(gankBean.getResults());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {

    }
}
