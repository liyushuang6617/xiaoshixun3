package com.example.geek.zhuhuribaomvp;

import com.example.geek.base.BaseView;
import com.example.geek.bean.ZhihuRibaoBean;

public interface ZbV extends BaseView {
    void onSuccess(ZhihuRibaoBean zhihuRibaoBean);

    void onFail(String msg);
}
