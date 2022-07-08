package com.example.w_one.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.w_one.R;
import com.example.w_one.base.BaseActivity;
import com.example.w_one.model.bean.Result;
import com.example.w_one.presenter.ILoginPresenter;
import com.example.w_one.utils.PresenterManger;
import com.example.w_one.view.ILoginCallback;
import com.google.android.material.button.MaterialButton;

public class LoginAc extends BaseActivity implements ILoginCallback {
    private ILoginPresenter iLoginPresenter;
    private EditText login_zhnaghao;
    private EditText login_mima;
    private MaterialButton login_denglu;
    private TextView login_zhuce;

    @Override
    protected int getActivityID() {
        return R.layout.a_login;
    }
    protected void initPresenter() {
        iLoginPresenter= PresenterManger.getOutalllo().getiLoginPresenter();
        iLoginPresenter.registerViewCallback(this);
    }

    protected void initListener() {
        login_denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取用户输入的账号和密码
                String zhnaghao = login_zhnaghao.getText().toString().trim();
                String mima = login_mima.getText().toString().trim();
                if (zhnaghao!=null&&mima!=null){
                    //调用iLoginPresenter登陆方法
                    iLoginPresenter.getLogin(zhnaghao,mima);
                    System.out.println("你登陆的账号为："+zhnaghao);
                }
                else {
                    Toast.makeText(LoginAc.this, "不能为空", Toast.LENGTH_SHORT).show();

                }
            }
        });
        login_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(),ZhuceAC.class));
            }
        });
    }

    protected void loadData() {
    }

    protected void initView() {
        setSupportActionBar();
        setTitle("登录");
        setActionBarIcon(R.mipmap.back);
        toolbara.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        login_zhnaghao = (EditText) findViewById(R.id.login_zhnaghao);
        login_mima = (EditText) findViewById(R.id.login_mima);
        login_denglu = (MaterialButton) findViewById(R.id.login_denglu);
        login_zhuce = (TextView) findViewById(R.id.login_zhuce);

    }


    @Override
    public void onLoadLogin(Result result) {
        if (result.getCode()==200){
            insertBykEY("token",result.getToken());
            System.out.println("token: "+result.getToken());
            setResult(RESULT_OK);
            finish();
        }
        Toast.makeText(LoginAc.this, result.getMsg(), Toast.LENGTH_SHORT).show();

    }
}
