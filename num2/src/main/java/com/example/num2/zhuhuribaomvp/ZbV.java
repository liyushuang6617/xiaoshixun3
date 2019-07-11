package com.example.num2.zhuhuribaomvp;


import com.example.num2.base.BaseView;
import com.example.num2.bean.ZhihuRibaoBean;

public interface ZbV extends BaseView {
    void onSuccess(ZhihuRibaoBean zhihuRibaoBean);

    void onFail(String msg);
}
