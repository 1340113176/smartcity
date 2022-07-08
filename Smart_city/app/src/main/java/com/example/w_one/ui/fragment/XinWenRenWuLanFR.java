package com.example.w_one.ui.fragment;

import android.graphics.Color;
import android.view.View;
import com.example.w_one.R;
import com.example.w_one.base.BaseFragment;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import java.util.ArrayList;

public class XinWenRenWuLanFR extends BaseFragment {
    private BarChart chart;
    @Override
    protected int getFragmentID() {
        return R.layout.f_xinwen_renwulan;
    }
    protected void initView(View mRootView) {
        chart=mRootView.findViewById(R.id.chart);
        XAxis xAxis=chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        YAxis yAxis=chart.getAxisRight();
        yAxis.setEnabled(false);

        ArrayList<String> xobjects = new ArrayList<>();
        ArrayList<BarEntry> yobjects = new ArrayList<>();
        xobjects.add("iPhone13...");
        xobjects.add("长视频斗...");
        xobjects.add("互联网亲...");
        xobjects.add("什么是紧...");
        xobjects.add("让人热泪...");
        yobjects.add(new BarEntry(551,0));
        yobjects.add(new BarEntry(2688,1));
        yobjects.add(new BarEntry(252,2));
        yobjects.add(new BarEntry(374,3));
        yobjects.add(new BarEntry(441,4));

        BarDataSet set=new BarDataSet(yobjects,"点赞数");
        set.setValueTextSize(16);
        set.setColor(Color.rgb(33,11,239));
        BarData data = new BarData(xobjects,set);
        chart.setData(data);
        chart.animateXY(1500,2500);

    }

    protected void initPresenter() {

    }

    protected void initListener() {

    }

    protected void loadData() {

    }
}
