package com.example.work.base1;

public interface BaseCallBack<T> {

    void onSuccess(T t);

    void onFail(String msg);
}
