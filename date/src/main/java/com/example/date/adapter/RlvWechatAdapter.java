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
import com.example.date.bean.WechatBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        View view = View.inflate(context, R.layout.wechat_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(list.get(i).getPicUrl()).into(viewHolder.wechativ);
        viewHolder.wechattv1.setText(list.get(i).getTitle());
        viewHolder.wechattv2.setText(list.get(i).getCtime());
        viewHolder.wechattv3.setText(list.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.wechativ)
        ImageView wechativ;
        @BindView(R.id.wechattv1)
        TextView wechattv1;
        @BindView(R.id.wechattv2)
        TextView wechattv2;
        @BindView(R.id.wechattv3)
        TextView wechattv3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
