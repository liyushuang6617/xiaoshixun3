package com.example.date.zhihuf2mvp;

import com.example.date.base.BaseCallBack;
import com.example.date.base.BasePresenter;
import com.example.date.bean.ZhuanLanBean;

public class ZhuanlP extends BasePresenter<ZhuanlV,ZhuanLM> {
    public void getData() {
        if(myModel!=null){
            myModel.getData(new BaseCallBack<ZhuanLanBean>() {
                @Override
                public void onSuccess(ZhuanLanBean zhuanLanBean) {
                    if(myView!=null){
                        myView.onSuucess(zhuanLanBean);
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
