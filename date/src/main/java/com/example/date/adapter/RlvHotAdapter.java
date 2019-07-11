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
import com.example.date.bean.HotBean;

import java.util.ArrayList;

public class RlvHotAdapter extends RecyclerView.Adapter<RlvHotAdapter.ViewHodler> {
    private Context context;
    private ArrayList<HotBean.RecentBean> list;

    public RlvHotAdapter(Context context, ArrayList<HotBean.RecentBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context,R.layout.hot_item,null);
        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {
        Glide.with(context).load(list.get(i).getThumbnail()).into(viewHodler.iv);
        viewHodler.tv.setText(list.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
