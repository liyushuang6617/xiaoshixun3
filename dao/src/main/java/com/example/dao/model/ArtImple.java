package com.example.dao.model;

import com.example.dao.api.MyService;
import com.example.dao.bean.ArtBean;
import com.example.dao.callback.ArtCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArtImple implements ArtM {
    @Override
    public void getData(final ArtCallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyService.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Observable<ArtBean> art = retrofit.create(MyService.class).art();
        art.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArtBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArtBean artBean) {
                        if (artBean != null) {
                            callBack.onSuccess(artBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
