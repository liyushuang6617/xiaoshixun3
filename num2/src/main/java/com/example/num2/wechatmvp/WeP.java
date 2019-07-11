package com.example.num2.wechatmvp;


import com.example.num2.base.BaseCallBack;
import com.example.num2.base.BasePresenter;
import com.example.num2.bean.WechatBean;

public class WeP extends BasePresenter<WeV,WeM> {
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
