package com.example.w_one.ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.w_one.R;
import com.example.w_one.base.BaseActivity;
import com.example.w_one.model.bean.Result;
import com.example.w_one.presenter.IRegisterPresenter;
import com.example.w_one.utils.PresenterManger;
import com.example.w_one.view.IRegisterCallback;
import com.google.android.material.button.MaterialButton;

public class ZhuceAC extends BaseActivity implements IRegisterCallback {
    private EditText usernameEt, passwordEt, emailEt, phoneEt;
    private MaterialButton register_btn;
    private IRegisterPresenter mRegisterPresenter;
    @Override
    protected int getActivityID() {
        return R.layout.a_zhuce;
    }
    @Override
    protected void initView() {
        setSupportActionBar();
        setActionBarIcon(R.mipmap.back);
        setTitle("注册");
        usernameEt = findViewById(R.id.register_account);
        passwordEt = findViewById(R.id.register_password);
        emailEt = findViewById(R.id.register_email);
        phoneEt = findViewById(R.id.register_phone);
        register_btn = findViewById(R.id.register_btn);
    }
    @Override
    protected void initPresenter() {
        mRegisterPresenter = PresenterManger.getOutalllo().getiRegisterPresenter();
        mRegisterPresenter.registerViewCallback(this);
    }

    @Override
    protected void initListener() {
        toolbara.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRegisterPresenter != null) {
                    String username = usernameEt.getText().toString().trim();
                    String password = passwordEt.getText().toString().trim();
                    String email = emailEt.getText().toString().trim();
                    String phone = phoneEt.getText().toString().trim();
                    if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(email) || TextUtils.isEmpty(phone)) {
                        Toast.makeText(ZhuceAC.this,"不能为空",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    mRegisterPresenter.doRegister(username, password, email, phone);
                }
            }
        });
    }

    @Override
    public void onRegisterSuccess(Result result) {
//        Toast.makeText(ZhuceAC.this,result.getMsg(),Toast.LENGTH_SHORT).show();
        Toast.makeText(ZhuceAC.this,"注册成功",Toast.LENGTH_SHORT).show();

    }
}
