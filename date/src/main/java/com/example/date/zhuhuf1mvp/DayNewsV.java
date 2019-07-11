package com.example.date.zhuhuf1mvp;

import com.example.date.base.BaseView;
import com.example.date.bean.DateBean;
import com.example.date.bean.DayNewsBean;

public interface DayNewsV extends BaseView {
    void onDayNewsSuccess(DayNewsBean dayNewsBean);

    void onDateonSuccess(DateBean dateBean);

    void onFail(String msg);
}
