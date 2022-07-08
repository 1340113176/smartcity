package com.example.w_one.ui.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.w_one.R;
import com.example.w_one.model.bean.TingCheChnagRe;
import com.example.w_one.ui.activity.TingCheChnagXiangqingAc;
import java.util.ArrayList;
import java.util.List;

public class TingCheAdapter extends RecyclerView.Adapter<TingCheAdapter.Innor> {
    private List<TingCheChnagRe.RowsBean> mData=new ArrayList<>();
    @NonNull
    @Override
    public Innor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tingchechang,parent,false);
        return new Innor(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final Innor holder, int position) {
        final TingCheChnagRe.RowsBean rowsBean=mData.get(position);
        holder.setData(rowsBean);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), TingCheChnagXiangqingAc.class);
                intent.putExtra("opo",rowsBean.getId());
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {

        return mData.size()-19;
    }

    public void setMData(List<TingCheChnagRe.RowsBean> rowsBeans) {
        this.mData.clear();
        this.mData.addAll(rowsBeans);
        notifyDataSetChanged();
    }

    public class Innor extends RecyclerView.ViewHolder {
        private TextView item_tingchengcahng_name,item_tingchengcahng_Juli,item_tingchengcahng_dizhi
                ,item_tingchengcahng_shoufei,item_tingchengcahng_kongwei;
        public Innor(@NonNull View itemView) {
            super(itemView);
            item_tingchengcahng_name=itemView.findViewById(R.id.item_tingchengcahng_name);
            item_tingchengcahng_Juli=itemView.findViewById(R.id.item_tingchengcahng_Juli);
            item_tingchengcahng_dizhi=itemView.findViewById(R.id.item_tingchengcahng_dizhi);
            item_tingchengcahng_shoufei=itemView.findViewById(R.id.item_tingchengcahng_shoufei);
            item_tingchengcahng_kongwei=itemView.findViewById(R.id.item_tingchengcahng_kongwei);
        }

        public void setData(TingCheChnagRe.RowsBean rowsBean) {
            item_tingchengcahng_name.setText(rowsBean.getParkName());
            item_tingchengcahng_Juli.setText(rowsBean.getDistance()+"米");
            item_tingchengcahng_shoufei.setText(rowsBean.getRates()+"元/小时");
            item_tingchengcahng_dizhi.setText(rowsBean.getAddress());
            item_tingchengcahng_kongwei.setText("剩余空位:"+rowsBean.getVacancy());
            System.out.println("停车场名称： "+ rowsBean.getParkName());
        }
    }
}
