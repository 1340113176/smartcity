package com.example.w_one.backup;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.w_one.MainActivity;
import com.example.w_one.R;
import com.example.w_one.base.BaseActivity;
import com.example.w_one.utils.Constance;
import com.google.android.material.button.MaterialButton;

import java.io.IOException;

public class XXiuGaiMiMaAcc extends BaseActivity {
    private EditText xiugaimima_yuanmima;
    private EditText xiugaimima_xinmima;
    private MaterialButton xiugaimima_button;
    private DBOpenHelper mDBOpenHelper;

    @Override
    protected int getActivityID() {
        return R.layout.a_xiugaimima;
    }
    protected void initPresenter() {
        mDBOpenHelper = new DBOpenHelper(this);
    }

    protected void initListener() {
        xiugaimima_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Yzhnaghao = xiugaimima_yuanmima.getText().toString().trim();
                String Xmima = xiugaimima_xinmima.getText().toString().trim();
                if (Yzhnaghao==null&&Xmima==null){
                    Toast.makeText(XXiuGaiMiMaAcc.this, "不能为空", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (Yzhnaghao.equals(Constance.OP)){
                        mDBOpenHelper.updata(Xmima);
                        if (findBykEY("toke")!=null){
                            removeBykEY("toke");
                        }
                        if (findBykEY("token")!=null){
                            removeBykEY("token");
                        }
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                        Toast.makeText(XXiuGaiMiMaAcc.this, "修改成功，请重新登录！", Toast.LENGTH_SHORT).show();
                    }else {
                        System.out.println(Constance.OP);
                        Toast.makeText(XXiuGaiMiMaAcc.this, "原密码错误！", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    protected void initView() {
        setSupportActionBar();
        setTitle("修改密码");
        setActionBarIcon(R.mipmap.back);
        toolbara.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        xiugaimima_yuanmima = (EditText) findViewById(R.id.xiugaimima_yuanmima);
        xiugaimima_xinmima = (EditText) findViewById(R.id.xiugaimima_xinmima);
        xiugaimima_button = (MaterialButton) findViewById(R.id.xiugaimima_button);
    }
}
