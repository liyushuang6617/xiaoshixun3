package com.example.news.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.news.R;
import com.example.news.bean.ZhuanLanBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvZhuanlanAdapter extends RecyclerView.Adapter<RlvZhuanlanAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ZhuanLanBean.DataBean> list;

    public RlvZhuanlanAdapter(Context context, ArrayList<ZhuanLanBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.zl_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.zltv1.setText(list.get(i).getDescription());
        viewHolder.zltv2.setText(list.get(i).getName());
        Glide.with(context).load(list.get(i).getThumbnail()).into(viewHolder.zliv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.zliv)
        ImageView zliv;
        @BindView(R.id.zltv1)
        TextView zltv1;
        @BindView(R.id.zltv2)
        TextView zltv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
