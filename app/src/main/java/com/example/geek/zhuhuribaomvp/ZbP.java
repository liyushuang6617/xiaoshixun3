package com.example.geek.zhuhuribaomvp;

import com.example.geek.base.BaseCallBack;
import com.example.geek.base.BasePresenter;
import com.example.geek.bean.ZhihuRibaoBean;

public class ZbP extends BasePresenter<ZbV,ZbM> {
    public void getData() {
        if(m!=null){
            m.getData(new BaseCallBack<ZhihuRibaoBean>() {
                @Override
                public void onSuccess(ZhihuRibaoBean zhihuRibaoBean) {
                    if(v!=null){
                        v.onSuccess(zhihuRibaoBean);
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
