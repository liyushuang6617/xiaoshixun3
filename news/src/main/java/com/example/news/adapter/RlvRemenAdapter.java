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
import com.example.news.bean.RemenBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvRemenAdapter extends RecyclerView.Adapter<RlvRemenAdapter.ViewHolder> {

    private Context context;
    private ArrayList<RemenBean.RecentBean> list;

    public RlvRemenAdapter(Context context, ArrayList<RemenBean.RecentBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.rb_item3, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.rbtv2.setText(list.get(i).getTitle());
        Glide.with(context).load(list.get(i).getThumbnail()).into(viewHolder.rbiv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rbiv)
        ImageView rbiv;
        @BindView(R.id.rbtv2)
        TextView rbtv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
