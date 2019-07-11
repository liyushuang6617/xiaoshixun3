package com.example.geek.wechatmvp;

import com.example.geek.base.BaseView;
import com.example.geek.bean.WechatBean;

public interface WeV extends BaseView {
    void onSuccess(WechatBean wechatBean);

    void onFail(String msg);
}
