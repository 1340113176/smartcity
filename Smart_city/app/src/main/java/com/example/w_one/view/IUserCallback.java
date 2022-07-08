package com.example.w_one.view;

import com.example.w_one.model.bean.Result;
import com.example.w_one.model.bean.UserRe;

public interface IUserCallback {
    void onLoadUser(UserRe userRe);
    void onLoadXiuGaiMiMa(Result result);
    void onLoadYiJianFankUI(Result result);
    void onLoadXiuGaiXinXi(Result result);
}
