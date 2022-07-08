package com.example.w_one.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.w_one.R;
import com.example.w_one.model.bean.TingCheLiShiRe;
import java.util.ArrayList;
import java.util.List;

public class TingCheLisshiAdapter extends RecyclerView.Adapter<TingCheLisshiAdapter.Innor> {
    private List<TingCheLiShiRe.RowsBean> mData=new ArrayList<>();
    @NonNull
    @Override
    public Innor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lishitingche,parent,false);
        return new Innor(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final Innor holder, int position) {
        final TingCheLiShiRe.RowsBean rowsBean=mData.get(position);
        holder.setData(rowsBean);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setMData(List<TingCheLiShiRe.RowsBean> rowsBeans) {
        this.mData.clear();
        this.mData.addAll(rowsBeans);
        notifyDataSetChanged();
    }

    public class Innor extends RecyclerView.ViewHolder {
        private TextView item_tingchelishi;
        public Innor(@NonNull View itemView) {
            super(itemView);
            item_tingchelishi=itemView.findViewById(R.id.item_tingchelishi);
        }

        public void setData(TingCheLiShiRe.RowsBean rowsBean) {
            item_tingchelishi.setText(rowsBean.getParkName());
        }
    }
}
