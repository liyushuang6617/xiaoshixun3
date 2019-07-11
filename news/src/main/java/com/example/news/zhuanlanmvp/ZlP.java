package com.example.news.zhuanlanmvp;

import com.example.news.base.BaseCallBack;
import com.example.news.base.BasePresenter;
import com.example.news.bean.ZhuanLanBean;

public class ZlP extends BasePresenter<ZlV,ZlM> {
    public void getData() {
        if(myModel!=null){
            myModel.getData(new BaseCallBack<ZhuanLanBean>() {
                @Override
                public void onSuccess(ZhuanLanBean zhuanLanBean) {
                    if(myView!=null){
                        myView.onSuccess(zhuanLanBean);
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
