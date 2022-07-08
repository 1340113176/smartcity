package com.example.w_one.presenter.impl;
import com.example.w_one.model.Api;
import com.example.w_one.model.bean.AllFuWuRe;
import com.example.w_one.model.bean.XinWen1Re;
import com.example.w_one.presenter.IHomePresenter;
import com.example.w_one.utils.RetrofitManger;
import com.example.w_one.view.IHomeCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
public class HomePresenter implements IHomePresenter {
    private IHomeCallback iHomeCallback=null;
    @Override
    public void getFuWu() {
        Retrofit retrofit= RetrofitManger.getOutlllo().getRetrofit();
        Api api=retrofit.create(Api.class);
        Call<AllFuWuRe> call=api.getAllFuWuRe();
        call.enqueue(new Callback<AllFuWuRe>() {
            @Override
            public void onResponse(Call<AllFuWuRe> call, Response<AllFuWuRe> response) {
                System.out.println("首页服务--连接成功");
                AllFuWuRe result=response.body();
                iHomeCallback.onLoadFuWu(result.getRows().subList(0,10));
            }
            @Override
            public void onFailure(Call<AllFuWuRe> call, Throwable throwable) {
                System.out.println("首页服务--连接失败");
            }
        });
    }
    @Override
    public void getAllFuWu() {
        Retrofit retrofit= RetrofitManger.getOutlllo().getRetrofit();
        Api api=retrofit.create(Api.class);
        Call<AllFuWuRe> call=api.getAllFuWuRe();
        call.enqueue(new Callback<AllFuWuRe>() {
            @Override
            public void onResponse(Call<AllFuWuRe> call, Response<AllFuWuRe> response) {
                System.out.println("全部服务--连接成功");
                AllFuWuRe result=response.body();
                iHomeCallback.onLoadFuWu(result.getRows());
            }

            @Override
            public void onFailure(Call<AllFuWuRe> call, Throwable throwable) {
                System.out.println("全部服务--连接失败");

            }
        });
    }
    @Override
    public void getXinWen1() {
        Retrofit retrofit= RetrofitManger.getOutlllo().getRetrofit();
        Api api=retrofit.create(Api.class);
        Call<XinWen1Re> call=api.getXinWen1Re();
        call.enqueue(new Callback<XinWen1Re>() {
            @Override
            public void onResponse(Call<XinWen1Re> call, Response<XinWen1Re> response) {
                System.out.println("新闻1--连接成功");
                XinWen1Re result=response.body();
                iHomeCallback.onLoadXinwen1(result.getData());
            }

            @Override
            public void onFailure(Call<XinWen1Re> call, Throwable throwable) {
                System.out.println("新闻1--连接失败");

            }
        });
    }
    @Override
    public void registerViewCallback(IHomeCallback callback) {
        this.iHomeCallback=callback;
    }
    @Override
    public void unregisterViewCallback(IHomeCallback callback) {
        this.iHomeCallback=null;

    }
}
