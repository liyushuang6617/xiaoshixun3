package com.example.date.zhihuf2mvp;

import com.example.date.api.MyService;
import com.example.date.base.BaseCallBack;
import com.example.date.base.BaseModel;
import com.example.date.bean.ZhuanLanBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ZhuanLM extends BaseModel {
    public void getData(final BaseCallBack<ZhuanLanBean> baseCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyService.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Observable<ZhuanLanBean> sections = retrofit.create(MyService.class).sections();
        sections.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhuanLanBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZhuanLanBean zhuanLanBean) {
                        if (zhuanLanBean != null) {
                            baseCallBack.onSuccess(zhuanLanBean);
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
