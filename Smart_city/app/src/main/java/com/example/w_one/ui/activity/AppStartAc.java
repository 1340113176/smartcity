package com.example.w_one.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.w_one.MainActivity;
import com.example.w_one.R;

public class AppStartAc extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_start);
        //调用方法
        SharedPreferences sp=getSharedPreferences("s_c",MODE_PRIVATE);
        //设定默认值
        Boolean isload=sp.getBoolean("isload",true);
        //判断isload的值
        if (isload){
            SharedPreferences.Editor editor=sp.edit();
            //将isload的值改成false
            editor.putBoolean("isload",false);
            editor.commit();
            //跳转到引导页面
            startActivity(new Intent(getApplicationContext(),YindaoAC.class));
            finish();
        }
        else {
            //跳转到应用主页面
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }
}
