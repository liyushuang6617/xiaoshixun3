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

public class RlvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<ArtBean.BodyBean.ResultBean.DataBean> list;

    public RlvAdapter(Context context, ArrayList<ArtBean.BodyBean.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            View view = View.inflate(context, R.layout.item1, null);
            return new ViewHolder1(view);
        } else if (i == 1) {
            View view = View.inflate(context, R.layout.item2, null);
            return new ViewHolder2(view);
        } else if (list.get(i).getClassTag() == 3) {
            View view = View.inflate(context, R.layout.item3, null);
            return new ViewHolder3(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof ViewHolder1) {
            ViewHolder1 viewHolder1 = (ViewHolder1) viewHolder;
            viewHolder1.tv1.setText(list.get(i).getClassName());
            Glide.with(context).load(list.get(i).getClassCoverPic()).into(viewHolder1.iv1);

            viewHolder1.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (shiPin != null) {
                        shiPin.onShiPin(i, list.get(i));
                    }
                }
            });
        } else if (viewHolder instanceof ViewHolder2) {
            ViewHolder2 viewHolder2 = (ViewHolder2) viewHolder;
            viewHolder2.tv2.setText(list.get(i).getClassName());
            Glide.with(context).load(list.get(i).getClassCoverPic()).into(viewHolder2.iv2);
            viewHolder2.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (yinPin != null) {
                        yinPin.onYinPin(i, list.get(i));
                    }
                }
            });
        } else if (viewHolder instanceof ViewHolder3) {
            ViewHolder3 viewHolder3 = (ViewHolder3) viewHolder;
            viewHolder3.tv3.setText(list.get(i).getClassName());
            Glide.with(context).load(list.get(i).getClassCoverPic()).into(viewHolder3.iv3);

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getClassFormat() == 1) {
            return 0;
        } else if (list.get(position).getClassFormat() == 2) {
            return 1;
        } else if (list.get(position).getClassTag() == 3) {
            return 3;
        }
        return super.getItemViewType(position);
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        ImageView iv1;
        TextView tv1;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            iv1 = itemView.findViewById(R.id.iv1);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        ImageView iv2;
        TextView tv2;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            iv2 = itemView.findViewById(R.id.iv2);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }

    class ViewHolder3 extends RecyclerView.ViewHolder {
        ImageView iv3;
        TextView tv3;

        public ViewHolder3(@NonNull View itemView) {
            super(itemView);
            iv3 = itemView.findViewById(R.id.iv3);
            tv3 = itemView.findViewById(R.id.tv3);
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
