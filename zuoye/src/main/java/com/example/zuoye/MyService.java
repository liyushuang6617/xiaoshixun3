package com.example.zuoye;

import com.example.zuoye.bean.ArtBean;
import com.example.zuoye.bean.PinBean;
import com.example.zuoye.bean.ShiBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MyService {

    public String url = "https://api.yunxuekeji.cn/yunxue_app_api/course/";

    //
    @POST("getCourseByTypeAndMore?orderOn&classtype=031001004&forPeopleType&format&price&pageIndex=1&pageSize=10&")
    @FormUrlEncoded
    Observable<ArtBean> yunxue(@Field("classTag") int classTag);

    public String url2 = "https://api.yunxuekeji.cn/yunxue_app_api/course/getCourseChapterById/";

    @GET("{ID}/{ID}")
    Observable<PinBean> pin(@Path("ID") int id);

    @GET("{ID}/{ID}")
    Observable<ShiBean> shi(@Path("ID") int id);
}
