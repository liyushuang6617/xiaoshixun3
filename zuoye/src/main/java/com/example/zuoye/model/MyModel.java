package com.example.zuoye.model;

import com.example.zuoye.MyService;
import com.example.zuoye.bean.ArtBean;
import com.example.zuoye.callback.CallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel implements MyM {
    @Override
    public void getData(int classTag, final CallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<ArtBean> yunxue = retrofit.create(MyService.class).yunxue(classTag);
        yunxue.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArtBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArtBean bean) {
                        if (bean != null) {
                            callBack.onSuccess(bean);
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
