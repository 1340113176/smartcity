package com.example.w_one.presenter;

import com.example.w_one.base.IBasePresenter;
import com.example.w_one.view.IUserCallback;

public interface IUsrPresenter extends IBasePresenter<IUserCallback> {
    //获取账户详情信息
    void getUser(String token);
    //token进行验证,传入新密码和旧密码。
    void getXiuGaiMiMa(String token,String newPassword, String oldPassword);
    //意见反馈接口
    void getYiJianFankUI(String token,String content, String title);
    //修改个人信息接口
    void getXiuGaiXinXi(String token,String nickName, String phonenumber, String sex);
}
