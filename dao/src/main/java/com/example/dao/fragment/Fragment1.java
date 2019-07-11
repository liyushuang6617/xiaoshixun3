package com.example.dao.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dao.R;
import com.example.dao.adapter.RlvF1Adapter;
import com.example.dao.bean.ArtBean;
import com.example.dao.bean.ListBean;
import com.example.dao.model.ArtImple;
import com.example.dao.presenter.ArtP;
import com.example.dao.presenter.ArtPresenter;
import com.example.dao.utils.DbUtils;
import com.example.dao.view.ArtV;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements RlvF1Adapter.A, ArtV {


    private View view;
    private RecyclerView mRe;
    private ArrayList<ArtBean.DataBean> list;
    private RlvF1Adapter adapter;
    private TextView mTv;

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
        ArtP artP = new ArtPresenter(new ArtImple(), this);
        artP.getData();
    }

    private void initView(View inflate) {
        mRe = (RecyclerView) inflate.findViewById(R.id.re);
        mTv = (TextView) inflate.findViewById(R.id.tv);

        mTv.setText("合计:");
        list = new ArrayList<>();
        adapter = new RlvF1Adapter(getActivity(), list);
        mRe.setAdapter(adapter);
        mRe.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter.setA(this);
    }


    @Override
    public void onSuccess(ArtBean artBean) {
        list.addAll(artBean.getData());
        adapter.setList(list);
    }

    private static final String TAG = "Fragment1";

    @Override
    public void onFail(String msg) {
        Log.e(TAG, "onFail: " + msg);
    }

    private double a;

    @Override
    public void onChecked(int pos, ArtBean.DataBean bean) {
        String collect_num = bean.getCollect_num();
        double v = Double.parseDouble(collect_num);
        a += v;
        mTv.setText("合计:" + a + "元");

        Toast.makeText(getActivity(), "选中", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNoChecked(int pos, ArtBean.DataBean bean) {
        String collect_num = bean.getCollect_num();
        double v = Double.parseDouble(collect_num);
        a -= v;
        mTv.setText("合计:" + a + "元");


        Toast.makeText(getActivity(), "未选中", Toast.LENGTH_SHORT).show();
    }

}
