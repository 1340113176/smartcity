package com.example.w_one.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManger
//一个 RESTful 的 HTTP 网络请求框架的封装，网络请求的工作本质上是 OkHttp 完成，而 Retrofit 仅负责 网络请求接口的封装
{
    public static RetrofitManger getOutlllo() {
        return outlllo;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public static final RetrofitManger outlllo=new RetrofitManger();
    public final Retrofit retrofit;

    public RetrofitManger() {
        retrofit = new Retrofit.Builder()
        .baseUrl(Constance.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    }
}
