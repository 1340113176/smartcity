package com.example.w_one.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.example.w_one.R;
import com.example.w_one.base.BaseFragment;
import com.example.w_one.ui.activity.shequ.BannerXinagqingAC;
import com.example.w_one.ui.activity.shequ.BannerXinagqingAC2;
import com.example.w_one.ui.activity.shequ.SheQuXinWen1;
import com.example.w_one.ui.activity.shequ.SheQuXinWen2;
import com.example.w_one.ui.activity.shequ.SheQuXinWen3;
import com.example.w_one.ui.activity.shequ.WuYeGuanLiAc;
import com.google.android.material.button.MaterialButton;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import java.util.ArrayList;
import java.util.List;

public class SheQuFuWuFR extends BaseFragment  {
    private Banner shequ_shouye_banner;
    private List<Integer> imgPath;
    private MaterialButton shequfuwu_wuyefuwu_button;
    private LinearLayout shequfuwu_xinwen_1_ac;
    private LinearLayout shequfuwu_xinwen_2_ac;
    private LinearLayout shequfuwu_xinwen_3_ac;

    @Override
    protected int getFragmentID() {
        return R.layout.shequ_home;
    }
    protected void initView(View mRootView) {
        //添加轮播图图片
        imgPath = new ArrayList<>();
        imgPath.add(R.mipmap.shequ_tongzhi_1);
        imgPath.add(R.mipmap.shequ_tongzhi_2);
        MyaaPa myaaPa = new MyaaPa();
        //实例化控件
        shequ_shouye_banner = (Banner) mRootView.findViewById(R.id.shequ_shouye_banner);
        shequfuwu_wuyefuwu_button = mRootView.findViewById(R.id.shequfuwu_wuyefuwu_button);
        shequfuwu_xinwen_1_ac = mRootView.findViewById(R.id.shequfuwu_xinwen_1_ac);
        shequfuwu_xinwen_2_ac = mRootView.findViewById(R.id.shequfuwu_xinwen_2_ac);
        shequfuwu_xinwen_3_ac = mRootView.findViewById(R.id.shequfuwu_xinwen_3_ac);
        shequ_shouye_banner.setImageLoader(myaaPa);
        //点击智慧社区首页轮播图时
        shequ_shouye_banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int i) {
                if (i==0){
                    //跳转到物业通知页面
                    startActivity(new Intent(getContext(), BannerXinagqingAC.class));

                }else {
                    //跳转到社区通知页面
                    startActivity(new Intent(getContext(), BannerXinagqingAC2.class));
                }
            }
        });
        //运行轮播图控件
        shequ_shouye_banner.setImages(imgPath).start();
    }
    protected void initListener() {
        shequfuwu_wuyefuwu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), WuYeGuanLiAc.class);
                startActivity(intent);
            }
        });
        shequfuwu_xinwen_1_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), SheQuXinWen1.class);
                startActivity(intent);
            }
        });
        shequfuwu_xinwen_2_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), SheQuXinWen2.class);
                startActivity(intent);
            }
        });
        shequfuwu_xinwen_3_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), SheQuXinWen3.class);
                startActivity(intent);
            }
        });
    }

    private class MyaaPa extends ImageLoader {
        @Override
        public void displayImage(Context context, Object o, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(o).into(imageView);
        }
    }
}
