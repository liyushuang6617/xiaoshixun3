package com.example.zuoye.callback;


import com.example.zuoye.bean.ShiBean;

public interface CallBack2 {

    void onSuccess(ShiBean bean);

    void onFail(String msg);
}
