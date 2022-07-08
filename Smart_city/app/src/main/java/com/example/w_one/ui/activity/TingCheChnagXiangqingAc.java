package com.example.w_one.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.w_one.R;
import com.example.w_one.base.BaseActivity;
import com.example.w_one.model.bean.TingCheChnagRe;
import com.example.w_one.model.bean.TingCheLiShiRe;
import com.example.w_one.model.bean.TingCheXiangqingRe;
import com.example.w_one.presenter.ITingChePresenter;
import com.example.w_one.utils.Constance;
import com.example.w_one.utils.PresenterManger;
import com.example.w_one.view.ITingCHeCallback;
import java.util.List;

public class TingCheChnagXiangqingAc extends BaseActivity implements ITingCHeCallback {
    private ITingChePresenter iTingChePresenter;
    private ImageView tingchechangxinagqing_tupian;
    private TextView tingchechangxinagqing_name;
    private TextView tingchechangxinagqing_Juli;
    private TextView tingchechangxinagqing_dizhi;
    private TextView tingchechangxinagqing_shoufei;
    private TextView tingchechangxinagqing_kongwei;
    private TextView tingchechangxinagqing_duiwaikaifang;
    private int spp;


    @Override
    protected int getActivityID() {
        return R.layout.a_tingchechangxainqgiing;
    }

    protected void initView() {
        spp=getIntent().getIntExtra("opo",0);

        setSupportActionBar();
        setTitle("停车场详情");
        setActionBarIcon(R.mipmap.back);
        toolbara.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tingchechangxinagqing_tupian = (ImageView) findViewById(R.id.tingchechangxinagqing_tupian);
        tingchechangxinagqing_name = (TextView) findViewById(R.id.tingchechangxinagqing_name);
        tingchechangxinagqing_Juli = (TextView) findViewById(R.id.tingchechangxinagqing_Juli);
        tingchechangxinagqing_dizhi = (TextView) findViewById(R.id.tingchechangxinagqing_dizhi);
        tingchechangxinagqing_shoufei = (TextView) findViewById(R.id.tingchechangxinagqing_shoufei);
        tingchechangxinagqing_kongwei = (TextView) findViewById(R.id.tingchechangxinagqing_kongwei);
        tingchechangxinagqing_duiwaikaifang = (TextView) findViewById(R.id.tingchechangxinagqing_duiwaikaifang);
    }

    protected void initPresenter() {
        iTingChePresenter = PresenterManger.getOutalllo().getiTingChePresenter();
        iTingChePresenter.registerViewCallback(this);
    }

    protected void initListener() {

    }

    protected void loadData() {
        iTingChePresenter.getTingCheXiangqing(spp);
    }

    @Override
    public void onLoadTingChe(List<TingCheChnagRe.RowsBean> rowsBeans) {

    }

    @Override
    public void onLoadTingCHeXiangqing(TingCheXiangqingRe.DataBean dataBeans) {
        Glide.with(getApplicationContext()).load(Constance.BASE_URL+dataBeans.getImgUrl()).into(tingchechangxinagqing_tupian);
        tingchechangxinagqing_name.setText(dataBeans.getParkName());
        tingchechangxinagqing_Juli.setText(dataBeans.getDistance()+"米");
        tingchechangxinagqing_dizhi.setText(dataBeans.getRates()+"元/小时");
        tingchechangxinagqing_kongwei.setText("剩余空位:"+dataBeans.getVacancy());
        if (dataBeans.getOpen().contains("N")){
            tingchechangxinagqing_duiwaikaifang.setText("不对外开放");
        }
        else {
            tingchechangxinagqing_duiwaikaifang.setText("对外开放");

        }
    }

    @Override
    public void onLoadTingCheLiShi(List<TingCheLiShiRe.RowsBean> rowsBeans) {

    }

}
