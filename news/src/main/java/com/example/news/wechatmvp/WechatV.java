package com.example.news.wechatmvp;

import com.example.news.base.BaseView;
import com.example.news.bean.WechatBean;

public interface WechatV extends BaseView {
    void onSuccess(WechatBean wechatBean);

    void onFail(String msg);
}
