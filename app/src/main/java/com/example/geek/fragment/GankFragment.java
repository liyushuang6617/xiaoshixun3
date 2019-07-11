package com.example.geek.fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geek.R;
import com.example.geek.adapter.VpGankAdapter;
import com.example.geek.base.BaseFragment;
import com.example.geek.fragment.ganfragment.GankCommonFragment;
import com.example.geek.fragment.ganfragment.GankFuliFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GankFragment extends BaseFragment {

    public static String[] tabTitle = new String[]{"Android", "iOS", "前端", "福利"};
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
    private Bundle bundle;
    private ArrayList<Fragment> list;
    private VpGankAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }

    BroadcastReceiver gankBroadCastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d(TAG, "onReceive: " + intent.getStringExtra("data"));
        }
    };

    private static final String TAG = "GankFragment";

    @Override
    protected void initView() {
        super.initView();
        initBroadcastReceiver();

        GankCommonFragment android = new GankCommonFragment();
        bundle = new Bundle();
        bundle.putString("fragment", tabTitle[0]);
        android.setArguments(bundle);

        GankCommonFragment ios = new GankCommonFragment();
        bundle = new Bundle();
        bundle.putString("fragment", tabTitle[1]);
        ios.setArguments(bundle);

        GankCommonFragment web = new GankCommonFragment();
        bundle = new Bundle();
        bundle.putString("fragment", tabTitle[2]);
        web.setArguments(bundle);

        GankFuliFragment fuli = new GankFuliFragment();
        bundle = new Bundle();
        bundle.putString("fragment", tabTitle[3]);
        fuli.setArguments(bundle);

        list = new ArrayList<>();
        list.add(android);
        list.add(ios);
        list.add(web);
        list.add(fuli);

        adapter = new VpGankAdapter(getChildFragmentManager(), list);
        vp.setAdapter(adapter);

        tab.addTab(tab.newTab().setText(tabTitle[0]));
        tab.addTab(tab.newTab().setText(tabTitle[1]));
        tab.addTab(tab.newTab().setText(tabTitle[2]));
        tab.addTab(tab.newTab().setText(tabTitle[3]));

        tab.setupWithViewPager(vp);

        tab.getTabAt(0).setText(tabTitle[0]);
        tab.getTabAt(1).setText(tabTitle[1]);
        tab.getTabAt(2).setText(tabTitle[2]);
        tab.getTabAt(3).setText(tabTitle[3]);
    }

    private void initBroadcastReceiver() {
        Log.d(TAG, "initBroadcastReceiver: ");
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(gankBroadCastReceiver, new IntentFilter("com.gank.search"));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(gankBroadCastReceiver);
    }
}
