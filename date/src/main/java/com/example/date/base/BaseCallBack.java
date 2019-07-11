package com.example.date.base;

public interface BaseCallBack<T> {

    void onSuccess(T t);

    void onFail(String msg);
}
