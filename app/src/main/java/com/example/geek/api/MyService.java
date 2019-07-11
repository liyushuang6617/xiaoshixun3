package com.example.geek.api;

import com.example.geek.bean.GankBean;
import com.example.geek.bean.WechatBean;
import com.example.geek.bean.ZhihuRibaoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyService {

    public String url = "http://news-at.zhihu.com/api/4/";

    @GET("news/latest")
    Observable<ZhihuRibaoBean> zb();

    public String url2 = "http://api.tianapi.com/wxnew/";

    @GET("?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<WechatBean> wechat();

    public String gankurl = "http://gank.io/api/data/";

    @GET("{tech}/{num}/{page}")
    Observable<GankBean> getTechList(@Path("tech") String tech, @Path("num") int num, @Path("page") int page);
}
