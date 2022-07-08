package com.example.w_one.ui.activity.shequ;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.w_one.R;
import com.example.w_one.base.BaseActivity;
import com.google.android.material.button.MaterialButton;

public class PingJiaAC extends BaseActivity {
    private EditText yijianfankui_biaoti;
    private EditText yijianfankui_neirong;
    private MaterialButton yijianfankui_button;
    @Override
    protected int getActivityID() {
        return R.layout.a_yijianfankui;
    }

    protected void initListener() {
        yijianfankui_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String biaoti = yijianfankui_biaoti.getText().toString().trim();
                String neirong = yijianfankui_neirong.getText().toString().trim();
                if (biaoti!=null&&neirong!=null){
                    Toast.makeText(PingJiaAC.this, "成功", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(PingJiaAC.this, "不能为空", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    protected void initView() {
        setSupportActionBar();
        setTitle("评价反馈");
        setActionBarIcon(R.mipmap.back);
        toolbara.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        yijianfankui_biaoti = (EditText) findViewById(R.id.yijianfankui_biaoti);
        yijianfankui_neirong = (EditText) findViewById(R.id.yijianfankui_neirong);
        yijianfankui_button = (MaterialButton) findViewById(R.id.yijianfankui_button);

    }
}
