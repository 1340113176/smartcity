package com.example.w_one.ui.activity;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.w_one.R;
import com.example.w_one.base.BaseActivity;
import com.example.w_one.model.bean.TingCheChnagRe;
import com.example.w_one.model.bean.TingCheLiShiRe;
import com.example.w_one.model.bean.TingCheXiangqingRe;
import com.example.w_one.presenter.ITingChePresenter;
import com.example.w_one.ui.adapter.TingCheLisshiAdapter;
import com.example.w_one.utils.PresenterManger;
import com.example.w_one.view.ITingCHeCallback;
import java.util.List;

public class TingCheChnagLiShiAc extends BaseActivity implements ITingCHeCallback {
    private TingCheLisshiAdapter tingCheLisshiAdapter;
    private ITingChePresenter iTingChePresenter;
    private RecyclerView a_lishitingche_list;

    @Override
    protected int getActivityID() {
        return R.layout.a_lishitingche;
    }
    protected void initView() {
        setSupportActionBar();
        setTitle("停车场历史");
        setActionBarIcon(R.mipmap.back);
        toolbara.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        a_lishitingche_list=findViewById(R.id.a_lishitingche_list);
        tingCheLisshiAdapter=new TingCheLisshiAdapter();
        a_lishitingche_list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        a_lishitingche_list.setAdapter(tingCheLisshiAdapter);

    }

    protected void initPresenter() {
        iTingChePresenter= PresenterManger.getOutalllo().getiTingChePresenter();
        iTingChePresenter.registerViewCallback(this);
    }

    protected void initListener() {

    }

    protected void loadData() {
        iTingChePresenter.getTingChelISHI();
    }

    @Override
    public void onLoadTingChe(List<TingCheChnagRe.RowsBean> rowsBeans) {
    }

    @Override
    public void onLoadTingCHeXiangqing(TingCheXiangqingRe.DataBean dataBeans) {

    }

    @Override
    public void onLoadTingCheLiShi(List<TingCheLiShiRe.RowsBean> rowsBeans) {
        tingCheLisshiAdapter.setMData(rowsBeans);
    }


}
