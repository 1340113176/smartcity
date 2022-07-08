package com.example.w_one.ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.w_one.R;
import com.example.w_one.base.BaseActivity;
import com.example.w_one.model.bean.Result;
import com.example.w_one.model.bean.UserRe;
import com.example.w_one.presenter.IUsrPresenter;
import com.example.w_one.utils.PresenterManger;
import com.example.w_one.view.IUserCallback;
import com.google.android.material.button.MaterialButton;

public class YiJanFanKuiAc extends BaseActivity implements IUserCallback {
    private IUsrPresenter iUsrPresenter;
    private EditText yijianfankui_biaoti;
    private EditText yijianfankui_neirong;
    private MaterialButton yijianfankui_button;

    @Override
    protected int getActivityID() {
        return R.layout.a_yijianfankui;
    }
    protected void initPresenter() {
        iUsrPresenter= PresenterManger.getOutalllo().getiUsrPresenter();
        iUsrPresenter.registerViewCallback(this);
    }

    protected void initListener() {
        yijianfankui_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String biaoti = yijianfankui_biaoti.getText().toString().trim();
                String neirong = yijianfankui_neirong.getText().toString().trim();
                if (biaoti!=null&&neirong!=null){
                    iUsrPresenter.getYiJianFankUI(findBykEY("token"),neirong,biaoti);
                }
                else {
                    Toast.makeText(YiJanFanKuiAc.this, "不能为空", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    protected void loadData() {
    }
    protected void initView() {
        setSupportActionBar();
        setTitle("意见反馈");
        setActionBarIcon(R.mipmap.back);
        toolbara.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        yijianfankui_biaoti = (EditText) findViewById(R.id.yijianfankui_biaoti);
        yijianfankui_neirong = (EditText) findViewById(R.id.yijianfankui_neirong);
        yijianfankui_button = (MaterialButton) findViewById(R.id.yijianfankui_button);

    }

    @Override
    public void onLoadUser(UserRe userRe) {

    }

    @Override
    public void onLoadXiuGaiMiMa(Result result) {
    }

    @Override
    public void onLoadYiJianFankUI(Result result) {
//        Toast.makeText(YiJanFanKuiAc.this,result.getMsg(),Toast.LENGTH_SHORT).show();
        Toast.makeText(YiJanFanKuiAc.this,"新增成功",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoadXiuGaiXinXi(Result result) {

    }

}
