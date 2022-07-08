package com.example.w_one.base;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.w_one.R;

public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar toolbara;
    protected abstract int getActivityID();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityID());
        initView();
        initPresenter();
        initListener();
        loadData();
    }
    protected void initView() {

    }

    protected void initPresenter() {

    }

    protected void initListener() {

    }

    protected void loadData() {

    }

    protected void setSupportActionBar(){
        toolbara=findViewById(R.id.toolbar);
        if (toolbara!=null){
            setSupportActionBar(toolbara);
        }
    }
    protected void setActionBarIcon(int reooold){
        if (toolbara!=null){
            toolbara.setNavigationIcon(reooold);
        }
    }

    public void insertBykEY(String k,String v){
        SharedPreferences sp=getSharedPreferences("s_C",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(k, v);
        editor.commit();
    }

    public String  findBykEY(String k){
        SharedPreferences sp=getSharedPreferences("s_C",MODE_PRIVATE);
        return sp.getString(k,null);
    }
    public void removeBykEY(String k){
        SharedPreferences sp=getSharedPreferences("s_C",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.remove(k);
        editor.commit();
    }
}
