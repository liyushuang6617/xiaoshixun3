package com.example.zuoye.callback;

import com.example.zuoye.bean.ArtBean;

public interface CallBack {

    void onSuccess(ArtBean bean);

    void onFail(String msg);
}
