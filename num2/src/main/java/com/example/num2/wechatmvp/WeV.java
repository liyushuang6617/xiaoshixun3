package com.example.num2.wechatmvp;


import com.example.num2.base.BaseView;
import com.example.num2.bean.WechatBean;

public interface WeV extends BaseView {
    void onSuccess(WechatBean wechatBean);

    void onFail(String msg);
}
