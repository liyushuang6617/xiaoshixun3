package com.example.gouwuche2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gouwuche2.R;
import com.example.gouwuche2.bean.ArtBean;

import java.util.ArrayList;

public class RlvMyAdapter extends RecyclerView.Adapter<RlvMyAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ArtBean.DataBean> list;
    private ArrayList<Boolean> booleans;

    public RlvMyAdapter(Context context, ArrayList<ArtBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(ArrayList<ArtBean.DataBean> list) {
        this.list = list;
        booleans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            booleans.add(false);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        viewHolder.cb.setChecked(booleans.get(i));
        viewHolder.tv.setText(list.get(i).getCollect_num() + "元");
        Glide.with(context).load(list.get(i).getPic()).into(viewHolder.iv);

        viewHolder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (booleans.get(i)) {
                    booleans.set(i, false);
                    if (a != null) {
                        a.onChecked(i, list.get(i));
                    }
                } else {
                    booleans.set(i, true);
                    if (a != null) {
                        a.onNoChecked(i, list.get(i));
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox cb;
        ImageView iv;
        TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cb = itemView.findViewById(R.id.cb);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }

    private A a;

    public void setA(A a) {
        this.a = a;
    }

    public interface A {
        void onChecked(int pos, ArtBean.DataBean bean);

        void onNoChecked(int pos, ArtBean.DataBean bean);
    }
}
