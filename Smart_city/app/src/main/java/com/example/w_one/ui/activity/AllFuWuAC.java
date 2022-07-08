package com.example.w_one.ui.activity;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.w_one.R;
import com.example.w_one.base.BaseActivity;
import com.example.w_one.model.bean.AllFuWuRe;
import com.example.w_one.model.bean.XinWen1Re;
import com.example.w_one.presenter.IHomePresenter;
import com.example.w_one.ui.adapter.FuWuAdapter;
import com.example.w_one.utils.PresenterManger;
import com.example.w_one.view.IHomeCallback;

import java.util.List;

public class AllFuWuAC extends BaseActivity implements IHomeCallback {
    private IHomePresenter iHomePresenter;

    private RecyclerView f_allfuwu_list;
    private FuWuAdapter fuWuAdapter;

    protected void initView() {
        setSupportActionBar();
        setTitle("全部服务");
        setActionBarIcon(R.mipmap.back);
        toolbara.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        f_allfuwu_list = (RecyclerView) findViewById(R.id.f_allfuwu_list);
        fuWuAdapter=new FuWuAdapter();
        f_allfuwu_list.setLayoutManager(new GridLayoutManager(getBaseContext(),4));
        f_allfuwu_list.setAdapter(fuWuAdapter);
    }

    @Override
    protected int getActivityID() {
        return R.layout.a_allfuwu;
    }

    protected void initPresenter() {
        iHomePresenter= PresenterManger.getOutalllo().getiHomePresenter();
        iHomePresenter.registerViewCallback(this);
    }

    protected void initListener() {

    }

    protected void loadData() {
        iHomePresenter.getAllFuWu();
    }

    @Override
    public void onLoadFuWu(List<AllFuWuRe.RowsBean> rowsBeans) {
        fuWuAdapter.setMData(rowsBeans);

    }

    @Override
    public void onLoadXinwen1(List<XinWen1Re.DataBean> dataBeans) {

    }
}
