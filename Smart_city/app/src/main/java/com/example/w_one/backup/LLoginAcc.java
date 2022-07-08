package com.example.w_one.backup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.w_one.R;
import com.example.w_one.base.BaseActivity;
import com.example.w_one.utils.Constance;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;

public class LLoginAcc extends BaseActivity {
    private DBOpenHelper mDBOpenHelper;
    private EditText et_User, et_Psw;
    private String userName;
    private SharedPreferences.Editor editor;

    private EditText login_zhnaghao;
    private EditText login_mima;
    private MaterialButton login_denglu;
    private TextView login_zhuce;

    @Override
    protected int getActivityID() {
        return R.layout.a_login;
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
    protected void initPresenter() {
        mDBOpenHelper = new DBOpenHelper(this);
        SharedPreferences sp = getSharedPreferences("user_mes", MODE_PRIVATE);
        editor = sp.edit();
        if(sp.getBoolean("flag",false)){
            String user_read = sp.getString("user","");
            String psw_read = sp.getString("psw","");
            login_zhnaghao.setText(user_read);
            login_mima.setText(psw_read);
        }
    }

    @Override
    protected void initListener() {
        login_denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = login_zhnaghao.getText().toString().trim();
                String password = login_mima.getText().toString().trim();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
                    ArrayList<Userwe> data = mDBOpenHelper.getAllData();
                    System.out.println(data);
                    boolean match = true;
                    boolean match2 = true;
                    for (int i = 0; i < data.size(); i++) {
                        Userwe user = data.get(i);
                        if ((name.equals(user.getUsername()) && password.equals(user.getPassword())) ||
                                (name.equals(user.getEmail()) && password.equals(user.getPassword())) ||
                                (name.equals(user.getPhone()) && password.equals(user.getPassword()))) {
                            userName = user.getUsername();
                            System.out.println(userName);
                            System.out.println(password);
                            Constance.OU=userName;
                            Constance.OP=user.getPassword();
                        } else {
                            match = false;
                        }
                    }
                    System.out.println(name);
                    System.out.println(password);
                    if (match) {
                        Toast.makeText(LLoginAcc.this, "登录成功", Toast.LENGTH_SHORT).show();
//                        finish();
                        Runnable target;
                        //用线程启动
                        Thread thread = new Thread() {
                            @Override
                            public void run() {
                                try {
//                                    sleep(2000);//2秒 模拟登录时间
                                    String user_name = userName;
                                    insertBykEY("toke","you");
                                    setResult(RESULT_OK);
                                    finish();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        };
                        thread.start();//打开线程
                    } else {
                        Toast.makeText(LLoginAcc.this, "用户名或密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LLoginAcc.this, "请输入你的用户名或密码", Toast.LENGTH_SHORT).show();
                }
            }

        });

        login_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), ZZhuceAcc.class));
            }
        });
    }
}
