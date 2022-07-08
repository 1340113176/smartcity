package com.example.w_one.presenter.impl;

import com.example.w_one.model.Api;
import com.example.w_one.model.Parrrms;
import com.example.w_one.model.bean.Result;
import com.example.w_one.presenter.ILoginPresenter;
import com.example.w_one.utils.RetrofitManger;
import com.example.w_one.view.ILoginCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginPresenter implements ILoginPresenter {
    private ILoginCallback iLoginCallback=null;

    @Override
    public void getLogin(String username, String password) {
        Retrofit retrofit= RetrofitManger.getOutlllo().getRetrofit();
        Api api=retrofit.create(Api.class);
        Parrrms parrrms = new Parrrms(username, password);
        Call<Result> call=api.getLogin(parrrms);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                System.out.println("登录--连接成功");
                Result result=response.body();
                iLoginCallback.onLoadLogin(result);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable throwable) {
                System.out.println("登录--连接失败");

            }
        });
    }

    @Override
    public void registerViewCallback(ILoginCallback callback) {
        this.iLoginCallback=callback;

    }

    @Override
    public void unregisterViewCallback(ILoginCallback callback) {
        this.iLoginCallback=null;

    }
}
