package com.example.zuoye;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.zuoye.adapter.VpMyAdapter;
import com.example.zuoye.bean.PinBean;
import com.example.zuoye.fragment.Fragment2;
import com.example.zuoye.model.MyModel1;
import com.example.zuoye.presenter.MyP1;
import com.example.zuoye.presenter.MyPresemter1;
import com.example.zuoye.view.MyV1;

import java.util.ArrayList;

import cn.jzvd.JZVideoPlayerStandard;

public class Main2Activity extends AppCompatActivity {

    private JZVideoPlayerStandard mJz;
    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> list;
    private ArrayList<String> title;
    private VpMyAdapter adapter;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mJz = (JZVideoPlayerStandard) findViewById(R.id.jz);
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);

        list = new ArrayList<>();
        list.add(new Fragment2());
        list.add(new Fragment2());
        list.add(new Fragment2());

        title = new ArrayList<>();
        title.add("介绍");
        title.add("目录");
        title.add("评价");

        adapter = new VpMyAdapter(getSupportFragmentManager(), list, title);
        mVp.setAdapter(adapter);
        mTab.setupWithViewPager(mVp);


        data = getIntent().getStringExtra("data");
        mJz.setUp("https://yunxue-bucket.oss-cn-shanghai.aliyuncs.com/classfile/0/PM129听罗永浩的锤子怎么敲？（吴思通）/PM129听罗永浩的锤子怎么敲？（吴思通）.mp3"
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "饺子闭眼睛");

        mJz.thumbImageView.setImageResource(R.drawable.ic_launcher_background);
    }
}
