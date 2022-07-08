package com.example.w_one.presenter.impl;

import com.example.w_one.model.Api;
import com.example.w_one.model.bean.TingCheChnagRe;
import com.example.w_one.model.bean.TingCheLiShiRe;
import com.example.w_one.model.bean.TingCheXiangqingRe;
import com.example.w_one.presenter.ITingChePresenter;
import com.example.w_one.utils.RetrofitManger;
import com.example.w_one.view.ITingCHeCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TingChePresenter implements ITingChePresenter {
    private ITingCHeCallback iTingCHeCallback=null;

    @Override
    public void getTingChe() {
        Retrofit retrofit= RetrofitManger.getOutlllo().getRetrofit();
        Api api=retrofit.create(Api.class);
        Call<TingCheChnagRe> call=api.getTingCheChnagRe();
        call.enqueue(new Callback<TingCheChnagRe>() {
            @Override
            public void onResponse(Call<TingCheChnagRe> call, Response<TingCheChnagRe> response) {
                System.out.println("停车场--连接成功");
                TingCheChnagRe result=response.body();
                iTingCHeCallback.onLoadTingChe(result.getRows());
            }

            @Override
            public void onFailure(Call<TingCheChnagRe> call, Throwable throwable) {
                System.out.println("停车场--连接失败");

            }
        });
    }

    @Override
    public void getTingCheXiangqing(int id) {
        Retrofit retrofit= RetrofitManger.getOutlllo().getRetrofit();
        Api api=retrofit.create(Api.class);
        Call<TingCheXiangqingRe> call=api.getTingCheXiangqingRe("prod-api/api/park/lot/"+id);
        call.enqueue(new Callback<TingCheXiangqingRe>() {
            @Override
            public void onResponse(Call<TingCheXiangqingRe> call, Response<TingCheXiangqingRe> response) {
                System.out.println("停车场详情--连接成功");
                TingCheXiangqingRe result=response.body();
                iTingCHeCallback.onLoadTingCHeXiangqing(result.getData());
            }

            @Override
            public void onFailure(Call<TingCheXiangqingRe> call, Throwable throwable) {
                System.out.println("停车场详情--连接失败");

            }
        });
    }

    @Override
    public void getTingChelISHI() {
        Retrofit retrofit= RetrofitManger.getOutlllo().getRetrofit();
        Api api=retrofit.create(Api.class);
        Call<TingCheLiShiRe> call=api.getTingCheLiShiRe();
        call.enqueue(new Callback<TingCheLiShiRe>() {
            @Override
            public void onResponse(Call<TingCheLiShiRe> call, Response<TingCheLiShiRe> response) {
                System.out.println("停车历史--连接成功");
                TingCheLiShiRe result=response.body();
                iTingCHeCallback.onLoadTingCheLiShi(result.getRows());
            }

            @Override
            public void onFailure(Call<TingCheLiShiRe> call, Throwable throwable) {
                System.out.println("停车历史--连接失败");

            }
        });
    }

    @Override
    public void registerViewCallback(ITingCHeCallback callback) {
        this.iTingCHeCallback=callback;
    }

    @Override
    public void unregisterViewCallback(ITingCHeCallback callback) {
        this.iTingCHeCallback=null;

    }
}
