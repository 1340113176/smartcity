package com.example.w_one.presenter;

import com.example.w_one.base.IBasePresenter;
import com.example.w_one.view.IHomeCallback;

public interface IHomePresenter extends IBasePresenter<IHomeCallback> {
    void getFuWu();
    void getAllFuWu();
    void getXinWen1();
}
