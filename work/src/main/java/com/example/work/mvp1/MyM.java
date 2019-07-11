package com.example.work.mvp1;

import com.example.work.base1.BaseCallBack;
import com.example.work.base1.BaseModel;

import java.util.Random;

public class MyM extends BaseModel {
    public void getData(BaseCallBack<String> baseCallBack) {
        Random random = new Random();
        int i = random.nextInt();
        if (i % 2 == 0) {
            baseCallBack.onSuccess(i+"");
        } else {
            baseCallBack.onFail(i+"");
        }
    }
}
