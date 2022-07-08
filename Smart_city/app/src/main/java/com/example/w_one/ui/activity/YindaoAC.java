package com.example.w_one.ui.activity;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.example.w_one.MainActivity;
import com.example.w_one.R;
import com.example.w_one.base.BaseActivity;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.List;

public class YindaoAC extends BaseActivity implements ViewPager.OnPageChangeListener {
    private ViewPager yindao_list;
    private MaterialButton yindao_baoucn;
    private MaterialButton yindao_xiugai;
    private LinearLayout yindao_ip_duankou;
    private MaterialButton yindao_wangluoshezhi;
    private MaterialButton yindao_jinruzhuye;
    private RelativeLayout yindao_wangluoshehzi_jinruzhuye;
    private LinearLayout yindao_xiaoyuandian;
    private List<ImageView> imageViews;
    private int a=0;

    @Override
    protected int getActivityID() {
        return R.layout.a_yindao;
    }


    protected void initView() {
        int[] ints = new int[]{
                R.mipmap.yindao_tupian1,
                R.mipmap.yindao_tupian2,
                R.mipmap.yindao_tupian5,
                R.mipmap.yindao_tupian4,
                R.mipmap.yindao_tupian3
        };
        imageViews=new ArrayList<>();
        for (int i=0;i<ints.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(ints[i]);
            imageViews.add(imageView);
        }

        yindao_list = (ViewPager) findViewById(R.id.yindao_list);
        yindao_baoucn = (MaterialButton) findViewById(R.id.yindao_baoucn);
        yindao_xiugai = (MaterialButton) findViewById(R.id.yindao_xiugai);
        yindao_ip_duankou = (LinearLayout) findViewById(R.id.yindao_ip_duankou);
        yindao_wangluoshezhi = (MaterialButton) findViewById(R.id.yindao_wangluoshezhi);
        yindao_jinruzhuye = (MaterialButton) findViewById(R.id.yindao_jinruzhuye);
        yindao_wangluoshehzi_jinruzhuye = (RelativeLayout) findViewById(R.id.yindao_wangluoshehzi_jinruzhuye);
        yindao_xiaoyuandian = (LinearLayout) findViewById(R.id.yindao_xiaoyuandian);

        yindao_list.setAdapter(new MyPager());
        yindao_list.addOnPageChangeListener(this);
        ((View)yindao_xiaoyuandian.getChildAt(0)).setBackgroundResource(R.drawable.huxian_beijing);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position==imageViews.size()-1){
            yindao_wangluoshehzi_jinruzhuye.setVisibility(View.VISIBLE);
            yindao_wangluoshezhi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    yindao_ip_duankou.setVisibility(View.VISIBLE);
                }
            });
        }
        else {
            yindao_wangluoshehzi_jinruzhuye.setVisibility(View.GONE);
            yindao_ip_duankou.setVisibility(View.GONE);
        }
        for (int j=0;j<imageViews.size();j++){
            if (position==j){
                ((View)yindao_xiaoyuandian.getChildAt(j)).setBackgroundResource(R.drawable.huxian_beijing);

            }
            else {
                ((View)yindao_xiaoyuandian.getChildAt(j)).setBackgroundResource(R.drawable.yuandain_hei);

            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    protected void initListener() {
        yindao_baoucn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(YindaoAC.this,"保存成功",Toast.LENGTH_SHORT).show();
                yindao_ip_duankou.setVisibility(View.GONE);
                a=1;
            }
        });
        yindao_xiugai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(YindaoAC.this,"修改成功",Toast.LENGTH_SHORT).show();
                yindao_ip_duankou.setVisibility(View.GONE);
            }
        });
        yindao_jinruzhuye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a==0){
                    Toast.makeText(YindaoAC.this,"请设置网络并保存",Toast.LENGTH_SHORT).show();
                }else {
                    startActivityForResult(new Intent(getBaseContext(), MainActivity.class),1);

                }
            }
        });
    }

    private class MyPager extends PagerAdapter {
        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView imageView=imageViews.get(position);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(imageViews.get(position));
        }
    }
}
