package com.example.geek.gankcommommvp;

import com.example.geek.base.BaseCallBack;
import com.example.geek.base.BasePresenter;
import com.example.geek.bean.GankBean;

public class GankCommonP extends BasePresenter<GankCommonV,GankCommonM> {
    public void getData(String key) {
        if(m!=null){
            m.getData(key, new BaseCallBack<GankBean>() {
                @Override
                public void onSuccess(GankBean gankBean) {
                    if(v!=null){
                        v.onSuccess(gankBean);
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
