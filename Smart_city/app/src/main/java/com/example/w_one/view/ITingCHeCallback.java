package com.example.w_one.view;

import com.example.w_one.model.bean.TingCheChnagRe;
import com.example.w_one.model.bean.TingCheLiShiRe;
import com.example.w_one.model.bean.TingCheXiangqingRe;

import java.util.List;

public interface ITingCHeCallback {
    void onLoadTingChe(List<TingCheChnagRe.RowsBean> rowsBeans);
    void onLoadTingCHeXiangqing(TingCheXiangqingRe.DataBean dataBeans);
    void onLoadTingCheLiShi(List<TingCheLiShiRe.RowsBean> rowsBeans);
}
