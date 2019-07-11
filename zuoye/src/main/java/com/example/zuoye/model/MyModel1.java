package com.example.zuoye.model;

import com.example.zuoye.MyService;
import com.example.zuoye.bean.PinBean;
import com.example.zuoye.callback.CallBack1;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel1 implements MyM1 {
    @Override
    public void getData(int id, final CallBack1 callBack1) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyService.url2)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Observable<PinBean> pin = retrofit.create(MyService.class).pin(id);
        pin.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PinBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PinBean pinBean) {
                        if (pinBean != null) {
                            callBack1.onSuccess(pinBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack1.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
