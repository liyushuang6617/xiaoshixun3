package com.example.news.ribaomvp;

import com.example.news.base.BaseView;
import com.example.news.bean.RiBaoBean;

public interface RbV extends BaseView {
    void onSuccess(RiBaoBean riBaoBean);

    void onFail(String msg);
}
