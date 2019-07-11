package com.example.work.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.work.R;
import com.example.work.bean.ArtBean;

import java.util.ArrayList;

public class RlvMyAdapter extends RecyclerView.Adapter<RlvMyAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ArtBean.DataBean.DatasBean> list;

    public RlvMyAdapter(Context context, ArrayList<ArtBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item1, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(context).load(list.get(i).getEnvelopePic()).into(viewHolder.iv);
        viewHolder.tv1.setText(list.get(i).getTitle());
        viewHolder.tv1.setText(list.get(i).getDesc());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a != null) {
                    a.onClick(i, list.get(i));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1;
        TextView tv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }

    private A a;

    public void setA(A a) {
        this.a = a;
    }

    public interface A {
        void onClick(int pos, ArtBean.DataBean.DatasBean bean);
    }
}
