package com.example.news.api;

import com.example.news.bean.DataBean;
import com.example.news.bean.RemenBean;
import com.example.news.bean.RiBaoBean;
import com.example.news.bean.WechatBean;
import com.example.news.bean.ZhuanLanBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyService {

    public String url = "http://api.tianapi.com/wxnew/";

    @GET("?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<WechatBean> wechat();

    public String url2 = "http://news-at.zhihu.com/api/4/";

    @GET("news/latest")
    Observable<RiBaoBean> ribao();

    @GET("sections")
    Observable<ZhuanLanBean> sections();

    @GET("news/hot")
    Observable<RemenBean> hot();

    /**
     * 日报过往数据
     * http://news-at.zhihu.com/api/4/news/before/20190710
     */
    @GET("api/4/news/before/{date}")
    Observable<DataBean> getDailyBeforeList(@Path("date") String date);
}
