package com.example.w_one.presenter;

import com.example.w_one.base.IBasePresenter;
import com.example.w_one.view.IXinWen2Cllback;

public interface IXinWen2Presetner extends IBasePresenter<IXinWen2Cllback> {
    void getXinwen2(int id);
    void reload(int id);
    void getXinWensouuso();
}
