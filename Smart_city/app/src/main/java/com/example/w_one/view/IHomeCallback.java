package com.example.w_one.view;

import com.example.w_one.model.bean.AllFuWuRe;
import com.example.w_one.model.bean.XinWen1Re;

import java.util.List;

public interface IHomeCallback {
    void onLoadFuWu(List<AllFuWuRe.RowsBean> rowsBeans);
    void onLoadXinwen1(List<XinWen1Re.DataBean> dataBeans);
}
