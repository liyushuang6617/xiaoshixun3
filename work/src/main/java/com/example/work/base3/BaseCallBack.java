package com.example.work.base3;

public interface BaseCallBack<T> {

    void onSuccess(T t);

    void onFail(String msg);
}
