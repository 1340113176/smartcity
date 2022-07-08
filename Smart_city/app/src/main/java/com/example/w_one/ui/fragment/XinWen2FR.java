package com.example.w_one.ui.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.w_one.R;
import com.example.w_one.base.BaseFragment;
import com.example.w_one.model.bean.XinWen1Re;
import com.example.w_one.model.bean.XinWen2Re;
import com.example.w_one.presenter.IXinWen2Presetner;
import com.example.w_one.ui.adapter.XinWen2Adapter;
import com.example.w_one.utils.Constance;
import com.example.w_one.utils.PresenterManger;
import com.example.w_one.view.IXinWen2Cllback;
import java.util.List;

public class XinWen2FR extends BaseFragment implements IXinWen2Cllback {
    private IXinWen2Presetner iXinWen2Presetner;
    private RecyclerView f_xinwen_2_list;
    private int mkkkid;
    private XinWen2Adapter xinWen2Adapter;

    public static XinWen2FR ouotllllop(XinWen1Re.DataBean dataBean){
        XinWen2FR xinWen2FR = new XinWen2FR();
        Bundle bundle = new Bundle();
        bundle.putInt(Constance.END_HOME_ID,dataBean.getId());
        xinWen2FR.setArguments(bundle);
        return xinWen2FR;
    }

    @Override
    protected int getFragmentID() {
        return R.layout.f_xinwen2;
    }
    protected void initView(View mRootView) {
        f_xinwen_2_list=mRootView.findViewById(R.id.f_xinwen_2_list);
        xinWen2Adapter=new XinWen2Adapter();
        f_xinwen_2_list.setLayoutManager(new LinearLayoutManager(getContext()));
        f_xinwen_2_list.setAdapter(xinWen2Adapter);
    }

    protected void initPresenter() {
        iXinWen2Presetner= PresenterManger.getOutalllo().getiXinWen2Presetner();
        iXinWen2Presetner.registerViewCallback(this);
    }

    protected void initListener() {

    }

    protected void loadData() {
        Bundle bundle=getArguments();
        mkkkid=bundle.getInt(Constance.END_HOME_ID);
        iXinWen2Presetner.getXinwen2(mkkkid);
    }
    @Override
    public void onLoadXinWen2(List<XinWen2Re.RowsBean> rowsBeans) {
        xinWen2Adapter.setMData(rowsBeans);
    }

    @Override
    public int gyeels() {
        return mkkkid;
    }
}
