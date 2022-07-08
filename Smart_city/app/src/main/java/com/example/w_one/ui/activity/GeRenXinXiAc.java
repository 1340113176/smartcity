package com.example.w_one.ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.w_one.R;
import com.example.w_one.base.BaseActivity;
import com.example.w_one.model.bean.Result;
import com.example.w_one.model.bean.UserRe;
import com.example.w_one.presenter.IUsrPresenter;
import com.example.w_one.utils.PresenterManger;
import com.example.w_one.view.IUserCallback;
import com.google.android.material.button.MaterialButton;

public class GeRenXinXiAc extends BaseActivity implements IUserCallback{
    private IUsrPresenter iUsrPresenter;
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



    @Override
    protected int getActivityID() {
        return R.layout.a_gerenxinxi;
    }

    protected void initPresenter() {
        iUsrPresenter = PresenterManger.getOutalllo().getiUsrPresenter();
        iUsrPresenter.registerViewCallback(this);
    }

    protected void initListener() {
        user_xiugai_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nicehng = user_yonghu_nicehng.getText().toString().trim();
                String shoujihao = user_yonghu_shoujihao.getText().toString().trim();
                String xingbie=nan.isChecked()?"0":"1";
                iUsrPresenter.getXiuGaiXinXi(findBykEY("token"), nicehng, shoujihao,xingbie);

            }
        });
    }

    protected void loadData() {
        iUsrPresenter.getUser(findBykEY("token"));
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


    @Override
    public void onLoadUser(UserRe userRe) {
        if (userRe.getCode()==200){
            user_yonghu_id.setText(String.valueOf(userRe.getUser().getUserId()));
            user_yonghu_yonghuming.setText(userRe.getUser().getUserName());
            user_yonghu_nicehng.setText(userRe.getUser().getNickName());
            user_yonghu_youxiang.setText(userRe.getUser().getEmail());
            user_yonghu_shoujihao.setText(userRe.getUser().getPhonenumber());
            user_yonghu_yu_e.setText(String.valueOf(userRe.getUser().getBalance()));
            user_yonghu_jifen.setText(String.valueOf(userRe.getUser().getScore()));
            if (userRe.getUser().getSex().contains("0")){
                nan.setChecked(true);
            }
            else {
                nv.setChecked(true);

            }
        }
    }

    @Override
    public void onLoadXiuGaiMiMa(Result result) {
    }

    @Override
    public void onLoadYiJianFankUI(Result result) {

    }

    @Override
    public void onLoadXiuGaiXinXi(Result result) {
        Toast.makeText(GeRenXinXiAc.this, result.getMsg(), Toast.LENGTH_SHORT).show();

    }


}
