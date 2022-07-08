package com.example.w_one.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.example.w_one.R;
import com.example.w_one.base.BaseFragment;
import com.example.w_one.model.bean.AllFuWuRe;
import com.example.w_one.model.bean.XinWen1Re;
import com.example.w_one.presenter.IHomePresenter;
import com.example.w_one.ui.activity.AllFuWuAC;
import com.example.w_one.ui.activity.SouSuoAc;
import com.example.w_one.ui.adapter.FuWuAdapter;
import com.example.w_one.utils.PresenterManger;
import com.example.w_one.view.IHomeCallback;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import java.util.ArrayList;
import java.util.List;

public class HomeFR extends BaseFragment implements IHomeCallback {
    private EditText shouye_shuru_sousuo;
    private IHomePresenter iHomePresenter;
    private Banner shouye_banner;
    private RecyclerView shouye_fuwu;
    private MaterialButton shouye_gengduofuwu;
    private TabLayout shouye_Xinwen1;
    private ViewPager2 shouye_xinwen2;
    private List<Integer> imgPath;
    private FuWuAdapter fuWuAdapter;
    //加载相应的前端xml文件内
    @Override
    protected int getFragmentID() {
        return R.layout.f_home;
    }
    //搜索框架
    protected View loadRootView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.base_sousuo,container,false);
    }
    protected void initView(View mRootView) {
        //添加首页轮播图图片
        imgPath=new ArrayList<>();
        imgPath.add(R.mipmap.shouye_lunbo_1);
        imgPath.add(R.mipmap.shouye_lunbo_2);
        MyaaP myaaP = new MyaaP();
        //实例化前端控件
        shouye_banner = (Banner) mRootView.findViewById(R.id.shouye_banner);
        shouye_fuwu = (RecyclerView) mRootView. findViewById(R.id.shouye_fuwu);
        shouye_gengduofuwu = (MaterialButton) mRootView.findViewById(R.id.shouye_gengduofuwu);
        shouye_Xinwen1 = (TabLayout)  mRootView.findViewById(R.id.shouye_Xinwen1);
        shouye_xinwen2 = (ViewPager2) mRootView. findViewById(R.id.shouye_xinwen2);
        shouye_shuru_sousuo = mRootView. findViewById(R.id.shouye_shuru_sousuo);
        shouye_banner.setImageLoader(myaaP);//设置轮播图
        shouye_banner.setImages(imgPath).start();
        //加载服务适配器
        fuWuAdapter=new FuWuAdapter();
        shouye_fuwu.setLayoutManager(new GridLayoutManager(getContext(),5));//每行显示5个服务
        shouye_fuwu.setAdapter(fuWuAdapter);
    }
    protected void initPresenter() {
        //实例化接口
        iHomePresenter= PresenterManger.getOutalllo().getiHomePresenter();
        iHomePresenter.registerViewCallback(this);
    }
    protected void loadData() {
        //接口的调用
        iHomePresenter.getFuWu();
        iHomePresenter.getXinWen1();
    }
    //”搜索“点击事件
    protected void initListener() {
        shouye_gengduofuwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AllFuWuAC.class));
            }
        });
        shouye_shuru_sousuo.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                String aapl=textView.getText().toString().trim();
                if (aapl!=null){
                    Intent intent = new Intent(getContext(), SouSuoAc.class);
                    intent.putExtra("lll",aapl);
                    startActivity(intent);
                }
                shouye_shuru_sousuo.setText("");
                return false;
            }
        });
    }

    @Override
    public void onLoadFuWu(List<AllFuWuRe.RowsBean> rowsBeans) {
        fuWuAdapter.setMData(rowsBeans);
    }

    @Override
    public void onLoadXinwen1(final List<XinWen1Re.DataBean> dataBeans) {
        shouye_xinwen2.setAdapter(new FragmentStateAdapter(getChildFragmentManager(),getLifecycle()) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return XinWen2FR.ouotllllop(dataBeans.get(position));
            }

            @Override
            public int getItemCount() {
                return dataBeans.size();
            }
        });
        new TabLayoutMediator(shouye_Xinwen1, shouye_xinwen2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(dataBeans.get(position).getName());
            }
        }).attach();
    }
    //重写ImageLoader类
    private class MyaaP extends ImageLoader {
        @Override
        public void displayImage(Context context, Object o, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(o).into(imageView);
        }
    }
}
