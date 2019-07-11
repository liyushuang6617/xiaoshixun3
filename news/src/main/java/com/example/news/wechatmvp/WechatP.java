package com.example.news.wechatmvp;

import com.example.news.base.BaseCallBack;
import com.example.news.base.BasePresenter;
import com.example.news.bean.WechatBean;

public class WechatP extends BasePresenter<WechatV,WechatM> {
    public void getData() {
        if(myModel!=null){
            myModel.getData(new BaseCallBack<WechatBean>() {
                @Override
                public void onSuccess(WechatBean wechatBean) {
                    if(myView!=null){
                        myView.onSuccess(wechatBean);
                    }
                }

                @Override
                public void onFail(String msg) {
                    if(myView!=null){
                        myView.onFail(msg);
                    }
                }
            });
        }
    }
}
