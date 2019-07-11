package com.example.zuoye.presenter;

import com.example.zuoye.bean.PinBean;
import com.example.zuoye.callback.CallBack1;
import com.example.zuoye.model.MyM1;
import com.example.zuoye.view.MyV1;

public class MyPresemter1 implements MyP1, CallBack1 {

    private MyM1 myM1;
    private MyV1 myV1;

    public MyPresemter1(MyM1 myM1, MyV1 myV1) {
        this.myM1 = myM1;
        this.myV1 = myV1;
    }

    @Override
    public void getData(int id) {
        if(myM1!=null){
            myM1.getData(id,this);
        }
    }

    @Override
    public void onSuccess(PinBean bean) {
        myV1.onSuccess(bean);
    }

    @Override
    public void onFail(String msg) {
        myV1.onFail(msg);
    }
}
