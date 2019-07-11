package com.example.news.remenmvp;

import com.example.news.base.BaseView;
import com.example.news.bean.RemenBean;

public interface RemV extends BaseView {
    void onSuccess(RemenBean remenBean);

    void onFail(String msg);
}
