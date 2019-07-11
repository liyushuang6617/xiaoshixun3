package com.example.work.base2;

public interface BaseCallBack<T> {

    void onSuccess(T t);

    void onFail(String msg);
}
