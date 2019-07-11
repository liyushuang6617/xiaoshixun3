package com.example.work;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.work.base1.BaseMvpActivity;
import com.example.work.mvp1.MyM;
import com.example.work.mvp1.MyP;
import com.example.work.mvp1.MyV;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends BaseMvpActivity<MyP, MyV, MyM> implements MyV {

    @BindView(R.id.bt)
    Button bt;
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected MyM initMvpModel() {
        return new MyM();
    }

    @Override
    protected MyV initMvpView() {
        return this;
    }

    @Override
    protected MyP initMvpPresenter() {
        return new MyP();
    }

    @Override
    protected void initListener() {
        super.initListener();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getData();
            }
        });
    }

    @Override
    public void onSuccess(String s) {
        tv.setText(s);
    }

    @Override
    public void onFail(String msg) {
        tv.setText(msg);
    }
}
