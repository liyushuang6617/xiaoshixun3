package com.example.work.mvp1;

import com.example.work.base1.BaseCallBack;
import com.example.work.base1.BasePresenter;

public class MyP extends BasePresenter<MyV,MyM> {
    public void getData() {
        if(myModel!=null){
            myModel.getData(new BaseCallBack<String>() {
                @Override
                public void onSuccess(String s) {
                    if(myView!=null){
                        myView.onSuccess(s);
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
