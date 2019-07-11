package com.example.zuoye.presenter;

import com.example.zuoye.bean.ArtBean;
import com.example.zuoye.callback.CallBack;
import com.example.zuoye.model.MyM;
import com.example.zuoye.view.MyV;

public class MyPresenter implements MyP, CallBack {

    private MyM myM;
    private MyV myV;

    public MyPresenter(MyM myM, MyV myV) {
        this.myM = myM;
        this.myV = myV;
    }

    @Override
    public void getData(int classTag) {
        if (myM != null) {
            myM.getData(classTag, this);
        }
    }

    @Override
    public void onSuccess(ArtBean bean) {
        myV.onSuccess(bean);
    }

    @Override
    public void onFail(String msg) {
        myV.onFail(msg);
    }
}
