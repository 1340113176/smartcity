package com.example.w_one.presenter.impl;

import com.example.w_one.model.Api;
import com.example.w_one.model.UserInfoParams;
import com.example.w_one.model.bean.Result;
import com.example.w_one.presenter.IRegisterPresenter;
import com.example.w_one.utils.RetrofitManger;
import com.example.w_one.view.IRegisterCallback;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterPresenter implements IRegisterPresenter {
    private IRegisterCallback mViewCallback = null;

    @Override
    public void doRegister(String account, String password, String email, String phone) {
        Retrofit retrofit = RetrofitManger.getOutlllo().getRetrofit();
        Api api = retrofit.create(Api.class);
        UserInfoParams params = new UserInfoParams(account,"",password,email,phone,"","");
        Call<Result> task = api.doRegister(params);
        task.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                System.out.println("注册--加载成功");
                int code = response.code();
                if(code == HttpURLConnection.HTTP_OK){
                    Result result = response.body();
                    if(mViewCallback != null){
                        mViewCallback.onRegisterSuccess(result);
                    }
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                System.out.println("注册--加载失败");

            }
        });
    }

    @Override
    public void registerViewCallback(IRegisterCallback callback) {
        this.mViewCallback = callback;
    }

    @Override
    public void unregisterViewCallback(IRegisterCallback callback) {
        this.mViewCallback = null;
    }
}
