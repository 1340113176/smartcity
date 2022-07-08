package com.example.w_one.presenter;

import com.example.w_one.base.IBasePresenter;
import com.example.w_one.view.IRegisterCallback;

public interface IRegisterPresenter extends IBasePresenter<IRegisterCallback> {
    void doRegister(String account, String password, String email, String phone);
}
