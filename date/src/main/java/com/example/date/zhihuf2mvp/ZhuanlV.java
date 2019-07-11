package com.example.date.zhihuf2mvp;

import com.example.date.base.BaseView;
import com.example.date.bean.ZhuanLanBean;

public interface ZhuanlV extends BaseView {
    void onSuucess(ZhuanLanBean zhuanLanBean);

    void onFail(String msg);
}
