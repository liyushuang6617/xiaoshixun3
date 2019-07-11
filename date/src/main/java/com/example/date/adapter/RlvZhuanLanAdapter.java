package com.example.date.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.date.R;
import com.example.date.bean.ZhuanLanBean;

import java.util.ArrayList;

public class RlvZhuanLanAdapter extends RecyclerView.Adapter<RlvZhuanLanAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ZhuanLanBean.DataBean> list;

    public RlvZhuanLanAdapter(Context context, ArrayList<ZhuanLanBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.zhuanlan_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(list.get(i).getThumbnail());
        viewHolder.tv1.setText(list.get(i).getDescription());
        viewHolder.tv2.setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1, tv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
}
