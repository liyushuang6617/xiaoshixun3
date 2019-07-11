package com.example.zuoye.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zuoye.R;
import com.example.zuoye.bean.ArtBean;

import java.util.ArrayList;

public class RlvAdapter2 extends RecyclerView.Adapter<RlvAdapter2.ViewHolder> {

    private Context context;
    private ArrayList<ArtBean.BodyBean.ResultBean.DataBean> list;

    public RlvAdapter2(Context context, ArrayList<ArtBean.BodyBean.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context,R.layout.item1,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tv1.setText(list.get(i).getClassName());
        Glide.with(context).load(list.get(i).getClassCoverPic()).into(viewHolder.iv1);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(i).getClassFormat() == 1){
                    if(shiPin!=null){
                        shiPin.onShiPin(i,list.get(i));
                    }
                }
                if(list.get(i).getClassFormat() == 2){
                    if(yinPin!=null){
                        yinPin.onYinPin(i,list.get(i));
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
        ImageView iv1;
        TextView tv1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv1 = itemView.findViewById(R.id.iv1);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }


    private ShiPin shiPin;

    public void setShiPin(ShiPin shiPin) {
        this.shiPin = shiPin;
    }

    public interface ShiPin {
        void onShiPin(int pos, ArtBean.BodyBean.ResultBean.DataBean bean);
    }

    private YinPin yinPin;

    public void setYinPin(YinPin yinPin) {
        this.yinPin = yinPin;
    }

    public interface YinPin {
        void onYinPin(int pos, ArtBean.BodyBean.ResultBean.DataBean bean);
    }

}
