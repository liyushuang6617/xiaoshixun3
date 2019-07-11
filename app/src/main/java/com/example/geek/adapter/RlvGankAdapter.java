package com.example.geek.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.geek.R;
import com.example.geek.bean.GankBean;

import java.util.ArrayList;

public class RlvGankAdapter extends RecyclerView.Adapter<RlvGankAdapter.ViewHolder> {

    private Context context;
    private ArrayList<GankBean.ResultsBean> list;

    public RlvGankAdapter(Context context, ArrayList<GankBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.gank_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tv1.setText(list.get(i).getDesc());
        viewHolder.tv2.setText(list.get(i).getWho());
        viewHolder.tv3.setText(list.get(i).getCreatedAt());
        Glide.with(context).load(list.get(i).getImages()).into(viewHolder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1, tv2, tv3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
        }
    }
}
