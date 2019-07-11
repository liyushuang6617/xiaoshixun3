package com.example.date.wechatmvp;

import com.example.date.base.BaseView;
import com.example.date.bean.WechatBean;

public interface WechatV extends BaseView {
    void onSuccess(WechatBean wechatBean);

    void onFail(String msg);
}
