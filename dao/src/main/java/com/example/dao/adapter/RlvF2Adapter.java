package com.example.dao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dao.R;
import com.example.dao.bean.ArtBean;
import com.example.dao.bean.ListBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvF2Adapter extends RecyclerView.Adapter<RlvF2Adapter.ViewHolder> {

    private Context context;
    private ArrayList<ListBean> list;

    public RlvF2Adapter(Context context, ArrayList<ListBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(ArrayList<ListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_f2, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tv1.setText(list.get(i).getTitle());
        viewHolder.tv2.setText(list.get(i).getCollect_num() + "元");
        Glide.with(context).load(list.get(i).getPic()).into(viewHolder.iv);

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
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.tv1)
        TextView tv1;
        @BindView(R.id.tv2)
        TextView tv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private A a;

    public void setA(A a) {
        this.a = a;
    }

    public interface A {
        void onClick(int pos, ListBean bean);
    }
}
