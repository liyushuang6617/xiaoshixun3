package com.example.news;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.news.base.BaseActivity;
import com.example.news.fragment.WechatFragment;
import com.example.news.fragment.ZhihuNewDaysFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//李玉爽 1811A
public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.nv)
    NavigationView nv;
    @BindView(R.id.dl)
    DrawerLayout dl;
    private FragmentManager manager;
    private ArrayList<Fragment> list;
    private ArrayList<Integer> title;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        toolbar.setTitle(R.string.ribao);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl, toolbar, R.string.about, R.string.about);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        dl.addDrawerListener(toggle);
        toggle.syncState();

        addFragments();

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fl, list.get(0));
        transaction.commit();

        addTitiles();
    }

    @Override
    protected void initListener() {
        super.initListener();
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                switch (menuItem.getItemId()) {
                    case R.id.zhihu:
                        switchFragments(0);
                        break;
                    case R.id.wechat:
                        switchFragments(1);
                        break;
                    case R.id.gank:
                        switchFragments(2);
                        break;
                    case R.id.gold:
                        switchFragments(3);
                        break;
                    case R.id.vtex:
                        switchFragments(4);
                        break;
                    case R.id.like:
                        switchFragments(5);
                        break;
                    case R.id.setting:
                        switchFragments(6);
                        break;
                    case R.id.about:
                        switchFragments(7);
                        break;

                }
                dl.closeDrawer(Gravity.LEFT);
                return false;
            }
        });
    }

    private int last;

    private void switchFragments(int type) {
        Fragment fragment = list.get(type);
        Fragment lastFragmet = list.get(last);

        FragmentTransaction transaction = manager.beginTransaction();

        if (!fragment.isAdded()) {
            transaction.add(R.id.fl, fragment);
        }

        transaction.show(fragment);
        transaction.hide(lastFragmet);
        transaction.commit();

        last = type;

        toolbar.setTitle(title.get(type));
    }

    private void addTitiles() {
        title = new ArrayList<>();
        title.add(R.string.ribao);
        title.add(R.string.wechat);
        title.add(R.string.gank);
        title.add(R.string.gold);
        title.add(R.string.vtex);
        title.add(R.string.like);
        title.add(R.string.setting);
        title.add(R.string.about);
    }

    private void addFragments() {
        list = new ArrayList<>();
        list.add(new ZhihuNewDaysFragment());
        list.add(new WechatFragment());
        list.add(new WechatFragment());
        list.add(new WechatFragment());
        list.add(new WechatFragment());
        list.add(new WechatFragment());
        list.add(new WechatFragment());
        list.add(new WechatFragment());
    }
}
