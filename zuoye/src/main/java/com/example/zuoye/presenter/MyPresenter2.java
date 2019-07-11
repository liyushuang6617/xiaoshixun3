package com.example.zuoye.presenter;

import com.example.zuoye.bean.ShiBean;
import com.example.zuoye.callback.CallBack2;
import com.example.zuoye.model.MyM2;
import com.example.zuoye.view.MyV2;

public class MyPresenter2 implements MyP2, CallBack2 {

    private MyM2 myM2;
    private MyV2 myV2;

    public MyPresenter2(MyM2 myM2, MyV2 myV2) {
        this.myM2 = myM2;
        this.myV2 = myV2;
    }

    @Override
    public void getData(int id) {
        if (myM2 != null) {
            myM2.getData(id, this);
        }
    }

    @Override
    public void onSuccess(ShiBean bean) {
        myV2.onSuccess(bean);
    }

    @Override
    public void onFail(String msg) {
        myV2.onFail(msg);
    }
}
