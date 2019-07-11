package com.example.news.ribaomvp;

import com.example.news.api.MyService;
import com.example.news.base.BaseCallBack;
import com.example.news.base.BaseModel;
import com.example.news.bean.RiBaoBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RbM extends BaseModel {
    public void getData(final BaseCallBack<RiBaoBean> baseCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyService.url2)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<RiBaoBean> ribao = retrofit.create(MyService.class).ribao();
        ribao.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RiBaoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RiBaoBean riBaoBean) {
                        if (riBaoBean != null) {
                            baseCallBack.onSuccess(riBaoBean);
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
