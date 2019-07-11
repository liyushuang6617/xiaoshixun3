package com.example.news.zhuanlanmvp;

import com.example.news.base.BaseView;
import com.example.news.bean.ZhuanLanBean;

public interface ZlV extends BaseView {
    void onSuccess(ZhuanLanBean zhuanLanBean);

    void onFail(String msg);
}
