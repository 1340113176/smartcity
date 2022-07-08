package com.example.w_one.backup;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.w_one.R;
import com.example.w_one.base.BaseActivity;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;

public class GGeRenXinXiAcc extends BaseActivity {
    private ImageView user_touxiang;
    private TextView user_yonghu_id;
    private TextView user_yonghu_yonghuming;
    private EditText user_yonghu_nicehng;
    private TextView user_yonghu_youxiang;
    private EditText user_yonghu_shoujihao;
    private RadioButton nan;
    private RadioButton nv;
    private TextView user_yonghu_yu_e;
    private TextView user_yonghu_jifen;
    private MaterialButton user_xiugai_button;
    private DBOpenHelper mDBOpenHelper;

    @Override
    protected int getActivityID() {
        return R.layout.a_gerenxinxi;
    }

    protected void initPresenter() {
        mDBOpenHelper = new DBOpenHelper(this);
        ArrayList<Userwe> data = mDBOpenHelper.getAllData();
        for (int i = 0; i < data.size(); i++) {
            Userwe user = data.get(i);
            System.out.println("用户id为: "+String.valueOf(user.getId()));
            user_yonghu_id.setText(String.valueOf(user.getId()));
            user_yonghu_nicehng.setText(user.getNicheng());
            user_yonghu_yonghuming.setText(user.getUsername());
            user_yonghu_youxiang.setText(user.getEmail());
            user_yonghu_shoujihao.setText(user.getPhone());
            user_yonghu_yu_e.setText(user.getYue());
            user_yonghu_jifen.setText(user.getJifen());
            if (user.getSex()==0){
                nan.setChecked(true);
            }
            else {
                nv.setChecked(true);
            }

        }
    }

    protected void initListener() {
        user_xiugai_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nicehng = user_yonghu_nicehng.getText().toString().trim();
                String shoujihao = user_yonghu_shoujihao.getText().toString().trim();
                int xingbie= Integer.parseInt(nan.isChecked()?"0":"1");
                mDBOpenHelper.updatauser(nicehng,shoujihao,xingbie);
                Toast.makeText(GGeRenXinXiAcc.this, "修改成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void initView() {
        setSupportActionBar();
        setTitle("个人信息");
        setActionBarIcon(R.mipmap.back);
        toolbara.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        user_touxiang = (ImageView) findViewById(R.id.user_touxiang);
        user_yonghu_id = (TextView) findViewById(R.id.user_yonghu_id);
        user_yonghu_yonghuming = (TextView) findViewById(R.id.user_yonghu_yonghuming);
        user_yonghu_nicehng = (EditText) findViewById(R.id.user_yonghu_nicehng);
        user_yonghu_youxiang = (TextView) findViewById(R.id.user_yonghu_youxiang);
        user_yonghu_shoujihao = (EditText) findViewById(R.id.user_yonghu_shoujihao);
        nan = (RadioButton) findViewById(R.id.nan);
        nv = (RadioButton) findViewById(R.id.nv);
        user_yonghu_yu_e = (TextView) findViewById(R.id.user_yonghu_yu_e);
        user_yonghu_jifen = (TextView) findViewById(R.id.user_yonghu_jifen);
        user_xiugai_button = (MaterialButton) findViewById(R.id.user_xiugai_button);
    }
}
