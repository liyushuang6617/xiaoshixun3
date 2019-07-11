package com.example.zuoye.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zuoye.bean.PinBean;

import java.util.ArrayList;

public class RlvF2Adapter extends RecyclerView.Adapter<RlvF2Adapter.ViewHolder> {
    private Context context;
    private ArrayList<PinBean.BodyBean.ResultBean> list;

    public RlvF2Adapter(Context context, ArrayList<PinBean.BodyBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, android.R.layout.activity_list_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tv.setText(list.get(i).getName());

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
        TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(android.R.id.text1);
        }
    }

    private A a;

    public void setA(A a) {
        this.a = a;
    }

    public interface A {
        void onClick(int pos, PinBean.BodyBean.ResultBean bean);
    }
}
