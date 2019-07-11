package com.example.news.base;

public abstract class BaseMvpFragment
        <P extends BasePresenter, V extends BaseView, M extends BaseModel> extends BaseFragment {

    protected P mPresenter;

    @Override
    protected void initMvp() {
        super.initMvp();

        mPresenter = initMvpPresenter();

        if (mPresenter != null) {
            mPresenter.attachView(initMvpView());
            mPresenter.addModel(initMvpModel());
        }
    }

    protected abstract M initMvpModel();

    protected abstract V initMvpView();

    protected abstract P initMvpPresenter();
}
