package com.example.w_one.ui.activity;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.w_one.R;
import com.example.w_one.base.BaseActivity;
import com.example.w_one.model.bean.XinWen2Re;
import com.example.w_one.presenter.IXinWen2Presetner;
import com.example.w_one.ui.adapter.XinWen2Adapter;
import com.example.w_one.utils.PresenterManger;
import com.example.w_one.view.IXinWen2Cllback;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SouSuoAc extends BaseActivity implements IXinWen2Cllback {
    private IXinWen2Presetner iXinWen2Presetner;
    private RecyclerView a_sousuo_list;
    private XinWen2Adapter xinWen2Adapter;
    private String plplpl;
    protected void initView() {
        plplpl=getIntent().getStringExtra("lll");
        setSupportActionBar();
        setTitle(plplpl+" 详情");
        setActionBarIcon(R.mipmap.back);
        toolbara.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        a_sousuo_list=findViewById(R.id.a_sousuo_list);
        xinWen2Adapter=new XinWen2Adapter();
        a_sousuo_list.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        a_sousuo_list.setAdapter(xinWen2Adapter);

    }
    protected void initPresenter() {
        iXinWen2Presetner= PresenterManger.getOutalllo().getiXinWen2Presetner();
        iXinWen2Presetner.registerViewCallback(this);
    }
    @Override
    protected int getActivityID() {
        return R.layout.a_sousuo;
    }


    protected void loadData() {
        iXinWen2Presetner.getXinWensouuso();
    }
    @Override
    public void onLoadXinWen2(List<XinWen2Re.RowsBean> rowsBeans) {
        List<XinWen2Re.RowsBean> xinlist=seaarch(rowsBeans,plplpl);
        xinWen2Adapter.setMData(xinlist);
    }

    private List<XinWen2Re.RowsBean> seaarch(List<XinWen2Re.RowsBean> rowsBeans, String plplpl) {
        List<XinWen2Re.RowsBean> rowsBeans1=new ArrayList<>();
        Pattern pattern=Pattern.compile(plplpl);
        for (int i=0;i<rowsBeans.size();i++){
            Matcher matcher=pattern.matcher(rowsBeans.get(i).getTitle());
            if (matcher.find()){
                rowsBeans1.add(rowsBeans.get(i));
            }
        }
        return rowsBeans1;
    }

    @Override
    public int gyeels() {
        return 0;
    }
}
