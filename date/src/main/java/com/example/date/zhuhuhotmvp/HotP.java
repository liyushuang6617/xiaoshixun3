package com.example.date.zhuhuhotmvp;

import com.example.date.base.BaseCallBack;
import com.example.date.base.BasePresenter;
import com.example.date.bean.HotBean;

public class HotP extends BasePresenter<HotV,HotM> {
    public void getData() {
        if(myModel!=null){
            myModel.getData(new BaseCallBack<HotBean>() {
                @Override
                public void onSuccess(HotBean hotBean) {
                    if(myView!=null){
                        myView.onSuccess(hotBean);
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
