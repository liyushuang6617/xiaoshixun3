package com.example.zuoye.model;

import com.example.zuoye.MyService;
import com.example.zuoye.bean.ShiBean;
import com.example.zuoye.callback.CallBack2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel2 implements MyM2 {
    @Override
    public void getData(int id, final CallBack2 callBack2) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyService.url2)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        final Observable<ShiBean> shi = retrofit.create(MyService.class).shi(id);
        shi.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShiBean shiBean) {
                        if (shiBean != null) {
                            callBack2.onSuccess(shiBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack2.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
