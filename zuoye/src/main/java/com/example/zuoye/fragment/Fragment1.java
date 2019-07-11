package com.example.zuoye.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.zuoye.Main2Activity;
import com.example.zuoye.R;
import com.example.zuoye.adapter.RlvAdapter;
import com.example.zuoye.adapter.RlvAdapter2;
import com.example.zuoye.bean.ArtBean;
import com.example.zuoye.model.MyModel;
import com.example.zuoye.presenter.MyP;
import com.example.zuoye.presenter.MyPresenter;
import com.example.zuoye.view.MyV;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements MyV, RlvAdapter2.ShiPin, RlvAdapter2.YinPin {


    private View view;
    private RecyclerView mRe;
    private ArrayList<ArtBean.BodyBean.ResultBean.DataBean> list;
    private RlvAdapter2 adapter;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_fragment1, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        MyP myP = new MyPresenter(new MyModel(), this);
        myP.getData(1);
        myP.getData(2);
        myP.getData(3);
    }

    private void initView(View inflate) {
        mRe = (RecyclerView) inflate.findViewById(R.id.re);

        list = new ArrayList<>();
        adapter = new RlvAdapter2(getActivity(), list);
        mRe.setAdapter(adapter);
        mRe.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter.setShiPin(this);
        adapter.setYinPin(this);
    }

    @Override
    public void onSuccess(ArtBean bean) {
        list.addAll(bean.getBody().getResult().getData());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {
        Log.e("Fragment1", "onFail: " + msg);
    }

    @Override
    public void onShiPin(int pos, ArtBean.BodyBean.ResultBean.DataBean bean) {
        Intent intent = new Intent(getActivity(), Main2Activity.class);
        intent.putExtra("data1", bean.getClassTeacherID());
        startActivity(intent);
        Toast.makeText(getActivity(), "视频", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onYinPin(int pos, ArtBean.BodyBean.ResultBean.DataBean bean) {
        Intent intent = new Intent(getActivity(), Main2Activity.class);
        intent.putExtra("data", bean.getClassTeacherID());
        startActivity(intent);
        Toast.makeText(getActivity(), "音频", Toast.LENGTH_SHORT).show();
    }

    //视频
//    @Override
//    public void onShiPin(int pos, ArtBean.BodyBean.ResultBean.DataBean bean) {
//        Intent intent = new Intent(getActivity(), Main2Activity.class);
//        intent.putExtra("data1", bean.getClassTeacherID());
//        startActivity(intent);
//        Toast.makeText(getActivity(), "视频", Toast.LENGTH_SHORT).show();
//    }

    //音频
//    @Override
//    public void onYinPin(int pos, ArtBean.BodyBean.ResultBean.DataBean bean) {
//
//        Intent intent = new Intent(getActivity(), Main2Activity.class);
//        intent.putExtra("data", bean.getClassTeacherID());
//        startActivity(intent);
//        Toast.makeText(getActivity(), "音频", Toast.LENGTH_SHORT).show();
//    }
}
