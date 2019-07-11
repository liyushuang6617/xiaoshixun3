package com.example.zuoye.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zuoye.Main2Activity;
import com.example.zuoye.R;
import com.example.zuoye.adapter.RlvF2Adapter;
import com.example.zuoye.bean.PinBean;
import com.example.zuoye.model.MyModel1;
import com.example.zuoye.presenter.MyP1;
import com.example.zuoye.presenter.MyPresemter1;
import com.example.zuoye.view.MyV1;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment implements MyV1, RlvF2Adapter.A {


    private View view;
    private RecyclerView mRe;
    private ArrayList<PinBean.BodyBean.ResultBean> list;
    private RlvF2Adapter adapter;
    private int data;

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_fragment2, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        data = getActivity().getIntent().getIntExtra("data", 1);
        MyP1 myP1 = new MyPresemter1(new MyModel1(), this);
        myP1.getData(data);
    }

    private void initView(View inflate) {
        mRe = (RecyclerView) inflate.findViewById(R.id.re);

        list = new ArrayList<>();
        adapter = new RlvF2Adapter(getActivity(), list);
        mRe.setAdapter(adapter);
        mRe.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter.setA(this);
    }

    @Override
    public void onSuccess(PinBean bean) {
        list.addAll(bean.getBody().getResult());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void onClick(int pos, PinBean.BodyBean.ResultBean bean) {
        Intent intent = new Intent(getActivity(), Main2Activity.class);
        intent.putExtra("data", bean.getUrl());
        startActivity(intent);
    }
}
