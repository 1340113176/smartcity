package com.example.w_one.view;

import com.example.w_one.model.bean.XinWen2Re;
import java.util.List;

public interface IXinWen2Cllback {
    void onLoadXinWen2(List<XinWen2Re.RowsBean> rowsBeans);
    int gyeels();
}
