package com.example.num3.wechatmvp;


import com.example.num3.base.BaseView;
import com.example.num3.bean.WechatBean;

public interface WeV extends BaseView {
    void onSuccess(WechatBean wechatBean);

    void onFail(String msg);
}
