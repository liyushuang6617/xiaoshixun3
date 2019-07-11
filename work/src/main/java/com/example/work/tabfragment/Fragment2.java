package com.example.work.tabfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.work.R;
import com.example.work.adapter.RlvF2Adapter;
import com.example.work.bean.ListBean;
import com.example.work.utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment implements RlvF2Adapter.A {


    private View view;
    private RecyclerView mRe;
    private ArrayList<ListBean> list = new ArrayList<>();
    private RlvF2Adapter adapter;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()){
            initData();
        }else {
            list.clear();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_fragment2, container, false);
        initView(inflate);
//        initData();
        return inflate;
    }

    private void initData() {
        List<ListBean> query = DbUtils.getDbUtils().query();
        list.addAll(query);
        adapter.setList(list);
        adapter.notifyDataSetChanged();

    }

    private void initView(View inflate) {
        mRe = (RecyclerView) inflate.findViewById(R.id.re);

        adapter = new RlvF2Adapter(getActivity(), list);
        mRe.setAdapter(adapter);
        mRe.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter.setA(this);
    }

    @Override
    public void onClick(int pos, ListBean bean) {
        list.remove(pos);
        DbUtils.getDbUtils().delete(bean);
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }
}
