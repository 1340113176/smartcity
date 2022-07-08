package com.example.w_one.ui.activity.shequ;

import android.content.Intent;
import android.view.View;
import com.example.w_one.R;
import com.example.w_one.base.BaseActivity;
import com.google.android.material.button.MaterialButton;

public class WuYeGuanLiAc extends BaseActivity implements View.OnClickListener {
    private MaterialButton shequ_pingjiafankui_1;
    private MaterialButton shequ_pingjiafankui_2;
    private MaterialButton shequ_pingjiafankui_3;
    private MaterialButton shequ_pingjiafankui_4;
    private MaterialButton shequ_pingjiafankui_5;


    @Override
    protected int getActivityID() {
        return R.layout.shequ_wuyefuwu;
    }



    protected void initView() {
        setSupportActionBar();
        setTitle("物业服务");
        setActionBarIcon(R.mipmap.back);
        toolbara.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        shequ_pingjiafankui_1 = (MaterialButton) findViewById(R.id.shequ_pingjiafankui_1);
        shequ_pingjiafankui_2 = (MaterialButton) findViewById(R.id.shequ_pingjiafankui_2);
        shequ_pingjiafankui_3 = (MaterialButton) findViewById(R.id.shequ_pingjiafankui_3);
        shequ_pingjiafankui_4 = (MaterialButton) findViewById(R.id.shequ_pingjiafankui_4);
        shequ_pingjiafankui_5 = (MaterialButton) findViewById(R.id.shequ_pingjiafankui_5);

        shequ_pingjiafankui_1.setOnClickListener(this);
        shequ_pingjiafankui_2.setOnClickListener(this);
        shequ_pingjiafankui_3.setOnClickListener(this);
        shequ_pingjiafankui_4.setOnClickListener(this);
        shequ_pingjiafankui_5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shequ_pingjiafankui_1:
                startActivity(new Intent(getApplicationContext(),PingJiaAC.class));
                break;

            case R.id.shequ_pingjiafankui_2:
                startActivity(new Intent(getApplicationContext(),PingJiaAC.class));
                break;

            case R.id.shequ_pingjiafankui_3:
                startActivity(new Intent(getApplicationContext(),PingJiaAC.class));
                break;

            case R.id.shequ_pingjiafankui_4:
                startActivity(new Intent(getApplicationContext(),PingJiaAC.class));
                break;

            case R.id.shequ_pingjiafankui_5:
                startActivity(new Intent(getApplicationContext(),PingJiaAC.class));
                break;

        }
    }
}
