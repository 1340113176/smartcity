package com.example.w_one.presenter;

import com.example.w_one.base.IBasePresenter;
import com.example.w_one.view.ITingCHeCallback;

public interface ITingChePresenter extends IBasePresenter<ITingCHeCallback> {
    void getTingChe();
    void getTingCheXiangqing(int id);
    void getTingChelISHI();
}
