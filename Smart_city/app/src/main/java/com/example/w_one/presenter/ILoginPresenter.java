package com.example.w_one.presenter;

import com.example.w_one.base.IBasePresenter;
import com.example.w_one.view.ILoginCallback;

public interface ILoginPresenter extends IBasePresenter<ILoginCallback> {
    void getLogin(String username, String password);
}
