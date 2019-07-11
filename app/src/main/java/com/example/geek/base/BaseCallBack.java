package com.example.geek.base;

public interface BaseCallBack<T> {

    void onSuccess(T t);

    void onFail(String msg);
}
