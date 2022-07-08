package com.example.w_one.backup;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.w_one.R;
import com.example.w_one.base.BaseActivity;
import com.google.android.material.button.MaterialButton;

public class ZZhuceAcc extends BaseActivity {
    private EditText usernameEt, passwordEt, emailEt, phoneEt;
    private MaterialButton register_btn;
    private DBOpenHelper mDBOpenHelper;
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
    protected void initListener() {
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEt.getText().toString().trim();
                String password1 = passwordEt.getText().toString().trim();
                String email = emailEt.getText().toString().trim();
                String phonenum = phoneEt.getText().toString().trim();
                //注册验证
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password1) && !TextUtils.isEmpty(email)&& !TextUtils.isEmpty(phonenum)) {
                    //判断两次密码是否一致
                    mDBOpenHelper.add(username, password1, email, phonenum);
                    Intent intent1 = new Intent(ZZhuceAcc.this, LLoginAcc.class);
                    startActivity(intent1);
                    finish();
                    Toast.makeText(ZZhuceAcc.this, "验证通过，注册成功", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(ZZhuceAcc.this, "注册信息不完善,注册失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void initPresenter() {
        mDBOpenHelper = new DBOpenHelper(this);
    }
}
