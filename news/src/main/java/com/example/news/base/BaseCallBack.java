package com.example.news.base;

public interface BaseCallBack<T> {

    void onSuccess(T t);

    void onFail(String msg);
}
