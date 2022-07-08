package com.example.w_one.base;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.w_one.R;
import static android.content.Context.MODE_PRIVATE;

public abstract class BaseFragment extends Fragment {
    public enum State{SUCCESS,NONE};
    private State state=State.NONE;
    private View mRootView,mSuccessView;
    private FrameLayout frameLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView=loadRootView(inflater,container);
        frameLayout=mRootView.findViewById(R.id.base_content);
        loadStateView(inflater,container);
        initView(mRootView);
        initPresenter();
        initListener();
        loadData();
        return mRootView;
    }

    protected void loadStateView(LayoutInflater inflater, ViewGroup container) {
        mSuccessView=loadSuccessView(inflater,container);
        frameLayout.addView(mSuccessView);
        setUpState(State.SUCCESS);
    }

    protected abstract int getFragmentID();
    protected View loadSuccessView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(getFragmentID(),container,false);
    }

    protected void setUpState(State success) {
        this.state=success;
        mSuccessView.setVisibility(state==State.SUCCESS?View.VISIBLE:View.GONE);
    }

    protected View loadRootView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.base_fragment,container,false);
    }

    protected void initView(View mRootView) {

    }

    protected void initPresenter() {

    }

    protected void initListener() {

    }

    protected void loadData() {

    }
    protected void release() { }
    public void insertBykEY(String k,String v){
        SharedPreferences sp=getContext().getSharedPreferences("s_C",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(k, v);
        editor.commit();
    }

    public String  findBykEY(String k){
        SharedPreferences sp=getContext().getSharedPreferences("s_C",MODE_PRIVATE);
        return sp.getString(k,null);
    }
    public void removeBykEY(String k){
        SharedPreferences sp=getContext().getSharedPreferences("s_C",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.remove(k);
        editor.commit();
    }
}
