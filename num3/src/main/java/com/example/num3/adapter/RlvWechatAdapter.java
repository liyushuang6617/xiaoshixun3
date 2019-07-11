package com.example.num3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.num3.R;
import com.example.num3.bean.WechatBean;

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
        View view = View.inflate(context, R.layout.zhihuribao_item3, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tv.setText(list.get(i).getTitle());
        Glide.with(context).load(list.get(i).getPicUrl()).into(viewHolder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv2);
        }
    }
}
