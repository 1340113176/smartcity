package com.example.w_one;

import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.w_one.backup.UUserFRR;
import com.example.w_one.base.BaseActivity;
import com.example.w_one.base.BaseFragment;
import com.example.w_one.ui.fragment.AllFuWuFR;
import com.example.w_one.ui.fragment.HomeFR;
import com.example.w_one.ui.fragment.SheQuFuWuFR;
import com.example.w_one.ui.fragment.XinWenRenWuLanFR;
import com.example.w_one.ui.fragment.UserFR;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity {

    private FrameLayout zong_frame;
    private BottomNavigationView renwulan;
    private FragmentManager fragmentManager;
    private HomeFR homeFR;
    private AllFuWuFR allFuWuFR;
    private XinWenRenWuLanFR xinWenRenWuLanFR;
    private UserFR userFR;
    private UUserFRR uUserFRR;
    private SheQuFuWuFR sheQuFuWuFR;

    @Override
    protected int getActivityID() {
        return R.layout.activity_main;
    }


    protected void initView() {
        zong_frame = (FrameLayout) findViewById(R.id.zong_frame);
        renwulan = (BottomNavigationView) findViewById(R.id.renwulan);
        homeFR=new HomeFR();
        allFuWuFR=new AllFuWuFR();
        xinWenRenWuLanFR =new XinWenRenWuLanFR();
        userFR=new UserFR();
        uUserFRR=new UUserFRR();
        sheQuFuWuFR=new SheQuFuWuFR();
        fragmentManager=getSupportFragmentManager();
        switchFragment(homeFR);
    }

    private BaseFragment lastFragment=null;
    private void switchFragment(BaseFragment baseFragment) {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        if (!baseFragment.isAdded()){
            fragmentTransaction.add(R.id.zong_frame,baseFragment);
        }
        else
        {
            fragmentTransaction.show(baseFragment);
        }
        if (lastFragment!=null&&lastFragment!=baseFragment){
            fragmentTransaction.hide(lastFragment);
        }
        lastFragment=baseFragment;
        fragmentTransaction.commit();
    }

    @Override
    protected void initListener() {
        renwulan.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.shouye){
                    switchFragment(homeFR);
                    System.out.println("你点击了--首页");
                }
                else if (item.getItemId()==R.id.quanbufuwu){
                    switchFragment(allFuWuFR);
                    System.out.println("你点击了--全部服务");
                }
                else if (item.getItemId()==R.id.shujufenxi){
                    switchFragment(xinWenRenWuLanFR);
                    System.out.println("你点击了--新闻");
                }
                else if (item.getItemId()==R.id.gerenzhongixn){
                    //uUserFRR,userFR
                    switchFragment(userFR);
                    System.out.println("你点击了--个人中心");
                }
                else if (item.getItemId()==R.id.zhihuishequ){
                    switchFragment(sheQuFuWuFR);
                    System.out.println("你点击了--智慧社区");
                }
                return true;
            }
        });
    }
}