package com.example.w_one.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.w_one.R;
import com.example.w_one.base.BaseActivity;
import com.example.w_one.model.bean.TingCheChnagRe;
import com.example.w_one.model.bean.TingCheLiShiRe;
import com.example.w_one.model.bean.TingCheXiangqingRe;
import com.example.w_one.presenter.ITingChePresenter;
import com.example.w_one.ui.adapter.TingCheAdapter2;
import com.example.w_one.utils.PresenterManger;
import com.example.w_one.view.ITingCHeCallback;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class TingCheChnagAc2 extends BaseActivity implements ITingCHeCallback {
    private TingCheAdapter2 tingCheAdapter2;
    private RecyclerView a_tingchechang_list;
    private ITingChePresenter iTingChePresenter;
    private MaterialButton tingchechang_button;
    private ImageView tingche_lishijilu;

    @Override
    protected int getActivityID() {
        return R.layout.a_tingchechang;
    }
    protected void initView() {
        setSupportActionBar();
        setTitle("停哪儿");//标题栏显示“停哪儿”
        setActionBarIcon(R.mipmap.back);//添加返回图标
        toolbara.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //实例化控件
        a_tingchechang_list=findViewById(R.id.a_tingchechang_list);
        tingchechang_button=findViewById(R.id.tingchechang_button);
        tingche_lishijilu=findViewById(R.id.tingche_lishijilu);//“停车场历史记录”按钮
        tingchechang_button.setVisibility(View.GONE);//隐藏“查看更多”按钮
        //加载适配器
        tingCheAdapter2=new TingCheAdapter2();
        a_tingchechang_list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        a_tingchechang_list.setAdapter(tingCheAdapter2);
    }
    protected void initListener() {
        //点击”停车场历史记录“按钮时跳转到TingCheChnagLiShiAc.class对应的activity
        tingche_lishijilu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),TingCheChnagLiShiAc.class));
                finish();
            }
        });
    }
    protected void initPresenter() {
        iTingChePresenter= PresenterManger.getOutalllo().getiTingChePresenter();
        iTingChePresenter.registerViewCallback(this);
    }



    protected void loadData() {
        iTingChePresenter.getTingChe();
    }

    @Override
    public void onLoadTingChe(List<TingCheChnagRe.RowsBean> rowsBeans) {
        tingCheAdapter2.setMData(rowsBeans);
    }

    @Override
    public void onLoadTingCHeXiangqing(TingCheXiangqingRe.DataBean dataBeans) {

    }

    @Override
    public void onLoadTingCheLiShi(List<TingCheLiShiRe.RowsBean> rowsBeans) {

    }


}
