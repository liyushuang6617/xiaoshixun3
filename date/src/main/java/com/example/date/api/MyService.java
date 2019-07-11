package com.example.date.api;

import com.example.date.bean.DateBean;
import com.example.date.bean.DayNewsBean;
import com.example.date.bean.HotBean;
import com.example.date.bean.WechatBean;
import com.example.date.bean.ZhuanLanBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyService {

    public String url = "http://news-at.zhihu.com/api/4/";

    @GET("news/latest")
    Observable<DayNewsBean> news();

    @GET("news/before/{date}")
    Observable<DateBean> date(@Path("date") String date);

    @GET("sections")
    Observable<ZhuanLanBean> sections();

    @GET("news/hot")
    Observable<HotBean> hot();

    public String wechaturl = "http://api.tianapi.com/wxnew/";

    @GET("?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<WechatBean> wechat();
}
