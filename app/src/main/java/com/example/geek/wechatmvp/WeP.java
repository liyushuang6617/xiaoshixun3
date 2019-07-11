package com.example.geek.wechatmvp;

import com.example.geek.base.BaseCallBack;
import com.example.geek.base.BasePresenter;
import com.example.geek.bean.WechatBean;

public class WeP extends BasePresenter<WeV,WeM>{
    public void getData() {
        if(m!=null){
            m.getData(new BaseCallBack<WechatBean>() {
                @Override
                public void onSuccess(WechatBean wechatBean) {
                    if(v!=null){
                        v.onSuccess(wechatBean);
                    }
                }

                @Override
                public void onFail(String msg) {
                    if(v!=null){
                        v.onFail(msg);
                    }
                }
            });
        }
    }
}
