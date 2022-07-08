package com.example.w_one.backup;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.example.w_one.MainActivity;
import com.example.w_one.R;
import com.example.w_one.base.BaseFragment;
import com.example.w_one.ui.activity.YiJanFanKuiAc;
import com.example.w_one.utils.Constance;
import com.google.android.material.button.MaterialButton;

public class UUserFRR extends BaseFragment{
    private ImageView user_touxiang;
    private TextView user_yonghuweidenglu;
    private MaterialButton user_denglu_button;
    private MaterialButton user_gerenxinxi;
    private MaterialButton user_xiugaimima;
    private MaterialButton user_yijianfankui;
    private MaterialButton user_tuichudenglu;
    private LinearLayout user_xiangqing;
    @Override
    protected int getFragmentID() {
        return R.layout.f_user;
    }
    protected void initView(View mRootView) {
        //实例化控件
        user_touxiang = (ImageView) mRootView.findViewById(R.id.user_touxiang);
        user_yonghuweidenglu = (TextView) mRootView.findViewById(R.id.user_yonghuweidenglu);
        user_denglu_button = (MaterialButton) mRootView.findViewById(R.id.user_denglu_button);
        user_gerenxinxi = (MaterialButton) mRootView.findViewById(R.id.user_gerenxinxi);
        user_xiugaimima = (MaterialButton) mRootView.findViewById(R.id.user_xiugaimima);
        user_yijianfankui = (MaterialButton)mRootView. findViewById(R.id.user_yijianfankui);
        user_tuichudenglu = (MaterialButton) mRootView.findViewById(R.id.user_tuichudenglu);
        user_xiangqing = (LinearLayout) mRootView.findViewById(R.id.user_xiangqing);
        if (findBykEY("toke")!=null){
            user_denglu_button.setVisibility(View.GONE);
            user_xiangqing.setVisibility(View.VISIBLE);
        }
    }
    protected void initListener() {
        //按钮点击事件，跳转至相应界面
        user_denglu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getContext(), LLoginAcc.class),1);
            }
        });
        user_tuichudenglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (findBykEY("toke")!=null){
                    removeBykEY("toke");
                }
                if (findBykEY("token")!=null){
                    removeBykEY("token");
                }
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });
        user_xiugaimima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), XXiuGaiMiMaAcc.class));
            }
        });
        user_gerenxinxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), GGeRenXinXiAcc.class));
            }
        });
        user_yijianfankui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getContext(), YiJanFanKuiAc.class),36);
            }
        });
    }

    protected void loadData() {
        //调用接口，并且判断token是否为空
        if (findBykEY("toke")!=null){
            user_touxiang.setImageResource(R.mipmap.touxiang);
            user_yonghuweidenglu.setText(Constance.OU);
        }
        else {
            user_yonghuweidenglu.setText("用户未登录");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (findBykEY("toke")!=null){
            user_denglu_button.setVisibility(View.GONE);
            user_xiangqing.setVisibility(View.VISIBLE);
            user_touxiang.setImageResource(R.mipmap.touxiang);
            user_yonghuweidenglu.setText(Constance.OU);
        }

    }

}
