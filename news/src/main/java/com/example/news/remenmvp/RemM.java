package com.example.news.remenmvp;

import com.example.news.api.MyService;
import com.example.news.base.BaseCallBack;
import com.example.news.base.BaseModel;
import com.example.news.bean.RemenBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemM extends BaseModel {
    public void getData(final BaseCallBack<RemenBean> baseCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyService.url2)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<RemenBean> hot = retrofit.create(MyService.class).hot();
        hot.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RemenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RemenBean remenBean) {
                        if (remenBean != null) {
                            baseCallBack.onSuccess(remenBean);
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
