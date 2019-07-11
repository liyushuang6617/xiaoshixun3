package com.example.geek.gankcommommvp;

import com.example.geek.base.BaseView;
import com.example.geek.bean.GankBean;

public interface GankCommonV extends BaseView {
    void onSuccess(GankBean gankBean);

    void onFail(String msg);
}
