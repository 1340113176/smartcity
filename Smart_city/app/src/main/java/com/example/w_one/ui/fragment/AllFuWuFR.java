package com.example.w_one.ui.fragment;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.w_one.R;
import com.example.w_one.base.BaseFragment;
import com.example.w_one.model.bean.AllFuWuRe;
import com.example.w_one.model.bean.XinWen1Re;
import com.example.w_one.presenter.IHomePresenter;
import com.example.w_one.ui.adapter.FuWuAdapter;
import com.example.w_one.utils.PresenterManger;
import com.example.w_one.view.IHomeCallback;
import java.util.List;

public class AllFuWuFR extends BaseFragment implements IHomeCallback {
    private IHomePresenter iHomePresenter;
    private RecyclerView f_allfuwu_list;
    private FuWuAdapter fuWuAdapter;

    @Override
    protected int getFragmentID() {
        return R.layout.f_allfuwu;
    }
    protected void initView(View mRootView) {
        f_allfuwu_list = (RecyclerView) mRootView.findViewById(R.id.f_allfuwu_list);
        fuWuAdapter=new FuWuAdapter();
        f_allfuwu_list.setLayoutManager(new GridLayoutManager(getContext(),4));
        f_allfuwu_list.setAdapter(fuWuAdapter);
    }

    protected void initPresenter() {
        iHomePresenter= PresenterManger.getOutalllo().getiHomePresenter();
        iHomePresenter.registerViewCallback(this);
    }

    protected void initListener() {

    }

    protected void loadData() {
        iHomePresenter.getAllFuWu();
    }

    @Override
    public void onLoadFuWu(List<AllFuWuRe.RowsBean> rowsBeans) {
        fuWuAdapter.setMData(rowsBeans);

    }

    @Override
    public void onLoadXinwen1(List<XinWen1Re.DataBean> dataBeans) {

    }
}
