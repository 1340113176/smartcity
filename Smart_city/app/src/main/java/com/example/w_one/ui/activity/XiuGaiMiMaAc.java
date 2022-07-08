package com.example.w_one.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.w_one.MainActivity;
import com.example.w_one.R;
import com.example.w_one.base.BaseActivity;
import com.example.w_one.model.bean.Result;
import com.example.w_one.model.bean.UserRe;
import com.example.w_one.presenter.IUsrPresenter;
import com.example.w_one.utils.PresenterManger;
import com.example.w_one.view.IUserCallback;
import com.google.android.material.button.MaterialButton;

public class XiuGaiMiMaAc extends BaseActivity implements IUserCallback {
    private IUsrPresenter iUsrPresenter;
    private EditText xiugaimima_yuanmima;
    private EditText xiugaimima_xinmima;
    private MaterialButton xiugaimima_button;

    @Override
    protected int getActivityID() {
        return R.layout.a_xiugaimima;
    }
    protected void initPresenter() {
        iUsrPresenter= PresenterManger.getOutalllo().getiUsrPresenter();
        iUsrPresenter.registerViewCallback(this);
    }

    protected void initListener() {
        xiugaimima_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Yzhnaghao = xiugaimima_yuanmima.getText().toString().trim();
                String Xmima = xiugaimima_xinmima.getText().toString().trim();
                if (Yzhnaghao!=null&&Xmima!=null){
                    iUsrPresenter.getXiuGaiMiMa(findBykEY("token"),Xmima,Yzhnaghao);
                }
                else {
                    Toast.makeText(XiuGaiMiMaAc.this, "不能为空", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    protected void loadData() {
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

    @Override
    public void onLoadUser(UserRe userRe) {

    }

    @Override
    public void onLoadXiuGaiMiMa(Result result) {
        if (iUsrPresenter!=null&&result.getMsg().contains("操作成功")){
            if (findBykEY("toke")!=null){
                removeBykEY("toke");
            }
            if (findBykEY("token")!=null){
                removeBykEY("token");
            }
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
        Toast.makeText(XiuGaiMiMaAc.this,result.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadYiJianFankUI(Result result) {

    }

    @Override
    public void onLoadXiuGaiXinXi(Result result) {

    }
}
