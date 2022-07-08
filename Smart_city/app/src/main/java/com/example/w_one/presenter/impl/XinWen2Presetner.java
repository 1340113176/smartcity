package com.example.w_one.presenter.impl;

import com.example.w_one.model.Api;
import com.example.w_one.model.bean.XinWen2Re;
import com.example.w_one.presenter.IXinWen2Presetner;
import com.example.w_one.utils.RetrofitManger;
import com.example.w_one.view.IXinWen2Cllback;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class XinWen2Presetner implements IXinWen2Presetner {
    private List<IXinWen2Cllback> iXinWen2Cllbacks=new ArrayList<>();
    @Override
    public void getXinwen2(int id) {
        Retrofit retrofit= RetrofitManger.getOutlllo().getRetrofit();
        Api api=retrofit.create(Api.class);
        Call<XinWen2Re> call=api.getXinWen2Re("prod-api/press/press/list?type="+id);
        System.out.println("prod-api/press/press/list?type="+id);
        call.enqueue(new Callback<XinWen2Re>() {
            @Override
            public void onResponse(Call<XinWen2Re> call, Response<XinWen2Re> response) {
                System.out.println("新闻2--连接成功");
                for (IXinWen2Cllback iXinWen2Cllback:iXinWen2Cllbacks){
                    XinWen2Re result=response.body();
                    iXinWen2Cllback.onLoadXinWen2(result.getRows());
                }
            }

            @Override
            public void onFailure(Call<XinWen2Re> call, Throwable throwable) {
                System.out.println("新闻2--连接失败");

            }
        });
    }

    @Override
    public void reload(int id) {
        this.getXinwen2(id);
    }

    @Override
    public void getXinWensouuso() {
        Retrofit retrofit= RetrofitManger.getOutlllo().getRetrofit();
        Api api=retrofit.create(Api.class);
        Call<XinWen2Re> call=api.getXinWen2Re("prod-api/press/press/list");
        call.enqueue(new Callback<XinWen2Re>() {
            @Override
            public void onResponse(Call<XinWen2Re> call, Response<XinWen2Re> response) {
                System.out.println("新闻2嗖嗖--连接成功");
                for (IXinWen2Cllback iXinWen2Cllback:iXinWen2Cllbacks){
                    XinWen2Re result=response.body();
                    iXinWen2Cllback.onLoadXinWen2(result.getRows());
                }
            }

            @Override
            public void onFailure(Call<XinWen2Re> call, Throwable throwable) {
                System.out.println("新闻2嗖嗖--连接失败");

            }
        });
    }

    @Override
    public void registerViewCallback(IXinWen2Cllback callback) {
        if (!iXinWen2Cllbacks.contains(callback)){
            iXinWen2Cllbacks.add(callback);
        }
    }

    @Override
    public void unregisterViewCallback(IXinWen2Cllback callback) {
        iXinWen2Cllbacks.remove(callback);
    }
}
