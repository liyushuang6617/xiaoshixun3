package com.example.date.ribaomvp;

import com.example.date.base.BaseCallBack;
import com.example.date.base.BasePresenter;
import com.example.date.bean.DateBean;
import com.example.date.bean.DayNewsBean;

public class DateP extends BasePresenter<DateV, DateM> {
    public void getDayNews() {
        if (myModel != null) {
            myModel.getDayNews(new BaseCallBack<DayNewsBean>() {
                @Override
                public void onSuccess(DayNewsBean dayNewsBean) {
                    if (myView != null) {
                        myView.onDayNewsSuccess(dayNewsBean);
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

    public void getDate(String date) {
        if(myModel!=null){
            myModel.getDate(date, new BaseCallBack<DateBean>() {
                @Override
                public void onSuccess(DateBean dateBean) {
                    if(myView!=null){
                        myView.onDateonSuccess(dateBean);
                    }
                }

                @Override
                public void onFail(String msg) {
                    if(myView!=null){
                        myView.onFail(msg);
                    }
                }
            });
        }
    }
}
