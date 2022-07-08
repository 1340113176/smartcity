package com.example.w_one.base;

public interface IBasePresenter<T> {
    void registerViewCallback(T callback);
    void unregisterViewCallback(T callback);
}
