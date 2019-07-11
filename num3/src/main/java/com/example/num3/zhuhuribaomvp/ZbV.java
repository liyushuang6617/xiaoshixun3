package com.example.num3.zhuhuribaomvp;


import com.example.num3.base.BaseView;
import com.example.num3.bean.ZhihuRibaoBean;

public interface ZbV extends BaseView {
    void onSuccess(ZhihuRibaoBean zhihuRibaoBean);

    void onFail(String msg);
}
