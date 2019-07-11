package com.example.work.mvp1;

import com.example.work.base1.BaseView;

public interface MyV extends BaseView {
    void onSuccess(String s);

    void onFail(String msg);
}
