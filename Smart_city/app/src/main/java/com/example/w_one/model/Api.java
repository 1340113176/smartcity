package com.example.w_one.model;

import com.example.w_one.model.bean.AllFuWuRe;
import com.example.w_one.model.bean.Result;
import com.example.w_one.model.bean.TingCheChnagRe;
import com.example.w_one.model.bean.TingCheLiShiRe;
import com.example.w_one.model.bean.TingCheXiangqingRe;
import com.example.w_one.model.bean.UserRe;
import com.example.w_one.model.bean.XinWen1Re;
import com.example.w_one.model.bean.XinWen2Re;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;

public interface Api {
    @POST("/prod-api/api/register")
    Call<Result> doRegister(@Body UserInfoParams params);
    @GET("prod-api/api/service/list")
    Call<AllFuWuRe> getAllFuWuRe();
    @GET("prod-api/press/category/list")
    Call<XinWen1Re> getXinWen1Re();
    @GET
    Call<XinWen2Re> getXinWen2Re(@Url String url);
    @GET
    Call<TingCheXiangqingRe> getTingCheXiangqingRe(@Url String url);
    @POST("prod-api/api/login")
    Call<Result> getLogin(@Body Parrrms parrrms);
    @GET("")
    Call<UserRe> getUser1();
    @GET("prod-api/api/common/user/getInfo")
    Call<UserRe> getUser(@Header("Authorization") String header);
    @GET("prod-api/api/park/lot/list")
    Call<TingCheChnagRe> getTingCheChnagRe();
    @GET("prod-api/api/park/lot/record/list")
    Call<TingCheLiShiRe> getTingCheLiShiRe();
    @PUT("prod-api/api/common/user/resetPwd")
    Call<Result> getXiuGaiMiMA(@Header("Authorization") String header,@Body PutMIMa putMIMa);
    @PUT("prod-api/api/common/user")
    Call<Result> getXiuGaiXinXi(@Header("Authorization") String header,@Body PutXinXi putXinXi);
    @POST("prod-api/api/common/feedback")
    Call<Result> getYiJIANFANKui(@Header("Authorization") String header,@Body PuTYiJianFanKui puTYiJianFanKui);
}
