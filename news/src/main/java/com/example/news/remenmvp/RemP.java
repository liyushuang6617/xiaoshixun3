package com.example.news.remenmvp;

import com.example.news.R;
import com.example.news.base.BaseCallBack;
import com.example.news.base.BasePresenter;
import com.example.news.bean.RemenBean;

public class RemP extends BasePresenter<RemV, RemM> {
    public void getData() {
        if(myModel!=null){
            myModel.getData(new BaseCallBack<RemenBean>() {
                @Override
                public void onSuccess(RemenBean remenBean) {
                    if(myView!=null){
                        myView.onSuccess(remenBean);
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
