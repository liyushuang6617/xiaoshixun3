package com.example.news.ribaomvp;

import com.example.news.base.BaseCallBack;
import com.example.news.base.BasePresenter;
import com.example.news.bean.RiBaoBean;

public class RbP extends BasePresenter<RbV, RbM> {
    public void getData() {
        if (myModel != null) {
            myModel.getData(new BaseCallBack<RiBaoBean>() {
                @Override
                public void onSuccess(RiBaoBean riBaoBean) {
                    if (myView != null) {
                        myView.onSuccess(riBaoBean);
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
