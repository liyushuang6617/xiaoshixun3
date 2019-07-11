package com.example.zuoye.callback;


import com.example.zuoye.bean.PinBean;

public interface CallBack1 {

    void onSuccess(PinBean bean);

    void onFail(String msg);
}
