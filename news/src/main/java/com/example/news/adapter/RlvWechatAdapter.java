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
import com.example.news.bean.WechatBean;

import java.util.ArrayList;

public class RlvWechatAdapter extends RecyclerView.Adapter<RlvWechatAdapter.ViewHolder> {

    private Context context;
    private ArrayList<WechatBean.NewslistBean> list;

    public RlvWechatAdapter(Context context, ArrayList<WechatBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.wechaat_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.wechattv.setText(list.get(i).getTitle());
        Glide.with(context).load(list.get(i).getPicUrl());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView wechativ;
        TextView wechattv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            wechativ = itemView.findViewById(R.id.wechativ);
            wechattv = itemView.findViewById(R.id.wechattv);
        }
    }
}
