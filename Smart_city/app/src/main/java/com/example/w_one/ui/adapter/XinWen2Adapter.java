package com.example.w_one.ui.adapter;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.w_one.R;
import com.example.w_one.model.bean.XinWen2Re;
import com.example.w_one.utils.Constance;
import java.util.ArrayList;
import java.util.List;

public class XinWen2Adapter extends RecyclerView.Adapter<XinWen2Adapter.Innor> {
    private List<XinWen2Re.RowsBean> mData=new ArrayList<>();
    @NonNull
    @Override
    public Innor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_xinwen2,parent,false);
        return new Innor(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final Innor holder, int position) {
        final XinWen2Re.RowsBean rowsBean=mData.get(position);
        holder.setData(rowsBean);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setMData(List<XinWen2Re.RowsBean> rowsBeans) {
        this.mData.clear();
        this.mData.addAll(rowsBeans);
        notifyDataSetChanged();
    }

    public class Innor extends RecyclerView.ViewHolder {
        private ImageView item_xinwen2_tupian;
        private TextView item_xinwen2_biaoti,item_xinwen2_fubiaoti,item_xinwen2_pinglunshu,
                item_xinwen2_shijian;
        public Innor(@NonNull View itemView) {
            super(itemView);
            item_xinwen2_tupian=itemView.findViewById(R.id.item_xinwen2_tupian);
            item_xinwen2_biaoti=itemView.findViewById(R.id.item_xinwen2_biaoti);
            item_xinwen2_fubiaoti=itemView.findViewById(R.id.item_xinwen2_fubiaoti);
            item_xinwen2_pinglunshu=itemView.findViewById(R.id.item_xinwen2_pinglunshu);
            item_xinwen2_shijian=itemView.findViewById(R.id.item_xinwen2_shijian);
        }

        public void setData(XinWen2Re.RowsBean rowsBean) {
            Glide.with(itemView.getContext()).load(Constance.BASE_URL+rowsBean.getCover()).into(item_xinwen2_tupian);
            item_xinwen2_biaoti.setText(rowsBean.getTitle());
            item_xinwen2_fubiaoti.setText(Html.fromHtml(rowsBean.getContent()));
            item_xinwen2_pinglunshu.setText(String.valueOf(rowsBean.getCommentNum()));
            item_xinwen2_shijian.setText(rowsBean.getCreateTime());
        }
    }
}
