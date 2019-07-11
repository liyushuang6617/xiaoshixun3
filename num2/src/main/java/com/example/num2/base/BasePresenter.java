package com.example.num2.base;

public class BasePresenter<V extends BaseView, M extends BaseModel> {

    protected M m;
    protected V v;

    public void addModel(M m) {
        this.m = m;
    }

    public void attachView(V v) {
        this.v = v;
    }
}
