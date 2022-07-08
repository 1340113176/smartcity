package com.example.w_one.ui.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.w_one.R;
import com.example.w_one.model.bean.AllFuWuRe;
import com.example.w_one.ui.activity.TingCheChnagAc;
import com.example.w_one.utils.Constance;
import java.util.ArrayList;
import java.util.List;

public class FuWuAdapter extends RecyclerView.Adapter<FuWuAdapter.Innor> {
    private List<AllFuWuRe.RowsBean> mData=new ArrayList<>();
    @NonNull
    @Override
    public Innor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fuwu,parent,false);
        return new Innor(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final Innor holder, int position) {
        final AllFuWuRe.RowsBean rowsBean=mData.get(position);
        holder.setData(rowsBean);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("服务id:"+rowsBean.getId());
                Intent intent=new Intent(holder.itemView.getContext(), TingCheChnagAc.class);
                if (rowsBean.getId()==17){
                    holder.itemView.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setMData(List<AllFuWuRe.RowsBean> rowsBeans) {
        this.mData.clear();
        this.mData.addAll(rowsBeans);
        notifyDataSetChanged();
    }

    public class Innor extends RecyclerView.ViewHolder {
        private ImageView item_fuwu_tupian;
        private TextView item_fuwu_title;
        public Innor(@NonNull View itemView) {
            super(itemView);
            item_fuwu_tupian=itemView.findViewById(R.id.item_fuwu_tupian);
            item_fuwu_title=itemView.findViewById(R.id.item_fuwu_title);
        }

        public void setData(AllFuWuRe.RowsBean rowsBean) {
            Glide.with(itemView.getContext()).load(Constance.BASE_URL+rowsBean.getImgUrl()).into(item_fuwu_tupian);
            item_fuwu_title.setText(rowsBean.getServiceName());
        }
    }
}
