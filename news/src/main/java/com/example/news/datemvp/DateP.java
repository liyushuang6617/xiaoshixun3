package com.example.news.datemvp;

import com.example.news.base.BaseCallBack;
import com.example.news.base.BasePresenter;
import com.example.news.bean.DataBean;
import com.example.news.bean.RiBaoBean;

public class DateP extends BasePresenter<DateV, DateM> {
    public void getData(String date) {
        if (myModel != null) {
            myModel.getData(date, new BaseCallBack<DataBean>() {
                @Override
                public void onSuccess(DataBean dataBean) {
                    if (myView != null) {
                        myView.onSuccess(dataBean);
                    }
                }

                @Override
                public void onFail(String msg) {
                    if (myView != null) {
                        myView.onFail(msg);
                    }
                }
            });
        }
    }

    public void getData1() {
        if (myModel != null) {
            myModel.getData1(new BaseCallBack<RiBaoBean>() {
                @Override
                public void onSuccess(RiBaoBean riBaoBean) {
                    if (myView != null) {
                        myView.onSuccess1(riBaoBean);
                    }
                }

                @Override
                public void onFail(String msg) {
                    if (myView != null) {
                        myView.onFail(msg);
                    }
                }
            });
        }
    }
}
