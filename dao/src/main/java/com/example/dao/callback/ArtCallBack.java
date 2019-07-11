package com.example.dao.callback;

import com.example.dao.bean.ArtBean;

public interface ArtCallBack {

    void onSuccess(ArtBean artBean);

    void onFail(String msg);
}
