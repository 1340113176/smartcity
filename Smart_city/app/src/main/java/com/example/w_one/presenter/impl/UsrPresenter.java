package com.example.w_one.presenter.impl;

import com.example.w_one.model.Api;
import com.example.w_one.model.PuTYiJianFanKui;
import com.example.w_one.model.PutMIMa;
import com.example.w_one.model.PutXinXi;
import com.example.w_one.model.bean.Result;
import com.example.w_one.model.bean.UserRe;
import com.example.w_one.presenter.IUsrPresenter;
import com.example.w_one.utils.RetrofitManger;
import com.example.w_one.view.IUserCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UsrPresenter implements IUsrPresenter {
    private IUserCallback iUserCallback=null;

    @Override
    public void getUser(String token) {
        //加载retrofit插件
        Retrofit retrofit= RetrofitManger.getOutlllo().getRetrofit();
        //实例化Api对象
        Api api=retrofit.create(Api.class);
        Call<UserRe> call=api.getUser(token);
        //编写接口
        call.enqueue(new Callback<UserRe>() {
            @Override
            public void onResponse(Call<UserRe> call, Response<UserRe> response) {
                System.out.println("个人信息--连接成功");
                UserRe result=response.body();
                iUserCallback.onLoadUser(result);
            }

            @Override
            public void onFailure(Call<UserRe> call, Throwable throwable) {
                System.out.println("个人信息--连接失败");

            }
        });
    }

    @Override
    public void getXiuGaiMiMa(String token, String newPassword, String oldPassword) {
        Retrofit retrofit= RetrofitManger.getOutlllo().getRetrofit();
        Api api=retrofit.create(Api.class);
        PutMIMa putMIMa = new PutMIMa(newPassword, oldPassword);
        Call<Result> call=api.getXiuGaiMiMA(token,putMIMa);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                System.out.println("修改密码--连接成功");
                Result result=response.body();
                iUserCallback.onLoadXiuGaiMiMa(result);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable throwable) {
                System.out.println("修改密码--连接失败");

            }
        });
    }

    @Override
    public void getYiJianFankUI(String token, String content, String title) {
        Retrofit retrofit= RetrofitManger.getOutlllo().getRetrofit();
        Api api=retrofit.create(Api.class);
        PuTYiJianFanKui puTYiJianFanKui = new PuTYiJianFanKui(content, title);
        Call<Result> call=api.getYiJIANFANKui(token,puTYiJianFanKui);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                System.out.println("意见反馈--连接成功");
                Result result=response.body();
                iUserCallback.onLoadYiJianFankUI(result);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable throwable) {
                System.out.println("意见反馈--连接失败");

            }
        });
    }

    @Override
    public void getXiuGaiXinXi(String token, String nickName, String phonenumber, String sex) {
        Retrofit retrofit= RetrofitManger.getOutlllo().getRetrofit();
        Api api=retrofit.create(Api.class);
        PutXinXi putXinXi = new PutXinXi(nickName, phonenumber, sex);
        Call<Result> call=api.getXiuGaiXinXi(token,putXinXi);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                System.out.println("修改个人信息--连接成功");
                Result result=response.body();
                iUserCallback.onLoadXiuGaiXinXi(result);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable throwable) {
                System.out.println("修改个人信息--连接失败");

            }
        });
    }

    @Override
    public void registerViewCallback(IUserCallback callback) {
        this.iUserCallback=callback;
    }

    @Override
    public void unregisterViewCallback(IUserCallback callback) {
        this.iUserCallback=null;

    }
}
