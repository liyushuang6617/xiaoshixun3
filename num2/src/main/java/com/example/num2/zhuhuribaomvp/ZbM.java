package com.example.num2.zhuhuribaomvp;


import com.example.num2.api.MyService;
import com.example.num2.base.BaseCallBack;
import com.example.num2.base.BaseModel;
import com.example.num2.bean.ZhihuRibaoBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ZbM extends BaseModel {
    public void getData(final BaseCallBack<ZhihuRibaoBean> baseCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyService.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Observable<ZhihuRibaoBean> zb = retrofit.create(MyService.class).zb();
        zb.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhihuRibaoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZhihuRibaoBean zhihuRibaoBean) {
                        if (zhihuRibaoBean != null) {
                            baseCallBack.onSuccess(zhihuRibaoBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        baseCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
