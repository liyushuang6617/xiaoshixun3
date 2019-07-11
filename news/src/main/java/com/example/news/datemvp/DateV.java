package com.example.news.datemvp;

import com.example.news.base.BaseView;
import com.example.news.bean.DataBean;
import com.example.news.bean.RiBaoBean;

public interface DateV extends BaseView {
    void onSuccess(DataBean dataBean);

    void onFail(String msg);

    void onSuccess1(RiBaoBean riBaoBean);
}
