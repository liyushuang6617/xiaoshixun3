package com.example.num3.api;


import com.example.num3.bean.WechatBean;
import com.example.num3.bean.ZhihuRibaoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyService {

    public String url = "http://news-at.zhihu.com/api/4/";

    @GET("news/latest")
    Observable<ZhihuRibaoBean> zb();

    public String url2 = "http://api.tianapi.com/wxnew/";

    @GET("?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<WechatBean> wechat();
}
