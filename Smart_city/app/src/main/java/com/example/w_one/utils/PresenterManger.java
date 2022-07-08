package com.example.w_one.utils;

import com.example.w_one.presenter.IHomePresenter;
import com.example.w_one.presenter.ILoginPresenter;
import com.example.w_one.presenter.IRegisterPresenter;
import com.example.w_one.presenter.ITingChePresenter;
import com.example.w_one.presenter.IUsrPresenter;
import com.example.w_one.presenter.IXinWen2Presetner;
import com.example.w_one.presenter.impl.HomePresenter;
import com.example.w_one.presenter.impl.LoginPresenter;
import com.example.w_one.presenter.impl.RegisterPresenter;
import com.example.w_one.presenter.impl.TingChePresenter;
import com.example.w_one.presenter.impl.UsrPresenter;
import com.example.w_one.presenter.impl.XinWen2Presetner;

public class PresenterManger {
    public static PresenterManger getOutalllo() {
        return outalllo;
    }
    public static final PresenterManger outalllo=new PresenterManger();

    private IHomePresenter iHomePresenter;
    private ILoginPresenter iLoginPresenter;
    private IUsrPresenter iUsrPresenter;
    private IXinWen2Presetner iXinWen2Presetner;
    private ITingChePresenter iTingChePresenter;
    private IRegisterPresenter iRegisterPresenter;

    public IHomePresenter getiHomePresenter() {
        return iHomePresenter;
    }

    public ILoginPresenter getiLoginPresenter() {
        return iLoginPresenter;
    }

    public IUsrPresenter getiUsrPresenter() {
        return iUsrPresenter;
    }

    public IXinWen2Presetner getiXinWen2Presetner() {
        return iXinWen2Presetner;
    }

    public ITingChePresenter getiTingChePresenter() {
        return iTingChePresenter;
    }

    public IRegisterPresenter getiRegisterPresenter() {
        return iRegisterPresenter;
    }

    public PresenterManger(){
        iHomePresenter=new HomePresenter();
        iLoginPresenter=new LoginPresenter();
        iUsrPresenter=new UsrPresenter();
        iXinWen2Presetner=new XinWen2Presetner();
        iTingChePresenter= new TingChePresenter();
        iRegisterPresenter= new RegisterPresenter();
    }


}
