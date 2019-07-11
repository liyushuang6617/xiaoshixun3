package com.example.date.zhuhuhotmvp;

import com.example.date.base.BaseView;
import com.example.date.bean.HotBean;

public interface HotV extends BaseView {
    void onSuccess(HotBean hotBean);

    void onFail(String msg);
}
