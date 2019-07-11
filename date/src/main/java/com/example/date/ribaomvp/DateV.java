package com.example.date.ribaomvp;

import com.example.date.base.BaseView;
import com.example.date.bean.DateBean;
import com.example.date.bean.DayNewsBean;

public interface DateV extends BaseView {
    void onDayNewsSuccess(DayNewsBean dayNewsBean);

    void onFail(String msg);

    void onDateonSuccess(DateBean dateBean);
}
