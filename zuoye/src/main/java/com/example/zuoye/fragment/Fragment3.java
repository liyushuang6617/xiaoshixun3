package com.example.zuoye.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.zuoye.R;
import com.example.zuoye.adapter.ExpandAdapter;
import com.example.zuoye.bean.PinBean;
import com.example.zuoye.bean.ShiBean;
import com.example.zuoye.model.MyModel1;
import com.example.zuoye.model.MyModel2;
import com.example.zuoye.presenter.MyP1;
import com.example.zuoye.presenter.MyP2;
import com.example.zuoye.presenter.MyPresemter1;
import com.example.zuoye.presenter.MyPresenter2;
import com.example.zuoye.view.MyV1;
import com.example.zuoye.view.MyV2;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment implements MyV2 {


    private View view;
    private ExpandableListView mElv;
    private int data;
    private ArrayList<ShiBean.BodyBean.ResultBean> list;
    private ArrayList<ShiBean.BodyBean.ResultBean.ChildrenBean> list1;
    private ExpandAdapter adapter;

    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_fragment3, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        data = getActivity().getIntent().getIntExtra("data1", 1);
        MyP2 myP2 = new MyPresenter2(new MyModel2(), this);
        myP2.getData(data);
    }

    private void initView(View inflate) {
        mElv = (ExpandableListView) inflate.findViewById(R.id.elv);

        list = new ArrayList<>();
        list1 = new ArrayList<>();
        adapter = new ExpandAdapter(getActivity(), list, list1);
        mElv.setAdapter(adapter);

    }

    @Override
    public void onSuccess(ShiBean bean) {
        list.addAll(bean.getBody().getResult());
        for (int i = 0; i < list.size(); i++) {
            list1.addAll(bean.getBody().getResult().get(i).getChildren());
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {

    }
}
