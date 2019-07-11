package com.example.work.api;

import com.example.work.bean.ArtBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyService {

    public String url = "https://www.wanandroid.com/project/list/1/";

    @GET("json?cid=294")
    Observable<ArtBean> art();
}
