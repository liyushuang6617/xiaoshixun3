package com.example.num3.base;

public interface BaseCallBack<T> {

    void onSuccess(T t);

    void onFail(String msg);
}
