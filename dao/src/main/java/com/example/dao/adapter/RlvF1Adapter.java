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
import com.example.dao.utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvF1Adapter extends RecyclerView.Adapter<RlvF1Adapter.ViewHolder> {

    private Context context;
    private ArrayList<ArtBean.DataBean> list;
    private ArrayList<Boolean> booleans = new ArrayList<>();

    public RlvF1Adapter(Context context, ArrayList<ArtBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(ArrayList<ArtBean.DataBean> list) {
        this.list = list;
        for (int i = 0; i < list.size(); i++) {
            booleans.add(false);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_f1, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final ArtBean.DataBean bean = list.get(i);
        viewHolder.cb.setChecked(booleans.get(i));
        viewHolder.tv1.setText(bean.getTitle());
        viewHolder.tv2.setText(bean.getCollect_num() + "元");
        Glide.with(context).load(bean.getPic()).into(viewHolder.iv);

        viewHolder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ListBean listBean = new ListBean();
                listBean.setId(Long.valueOf(i));
                listBean.setTitle(bean.getTitle());
                listBean.setCollect_num(bean.getCollect_num());
                listBean.setPic(bean.getPic());
                if (booleans.get(i)) {
                    booleans.set(i, false);
                    if (a != null) {
                        a.onNoChecked(i, bean);
                    }
//                    List<ListBean> query = DbUtils.getDbUtils().query();
//                    for (ListBean listbean :
//                            query) {
//                    }
                    DbUtils.getDbUtils().delete(listBean);
                } else {
                    booleans.set(i, true);
                    if (a != null) {
                        a.onChecked(i, bean);
                    }

                    DbUtils.getDbUtils().insert(listBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cb)
        CheckBox cb;
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
        void onChecked(int pos, ArtBean.DataBean bean);

        void onNoChecked(int pos, ArtBean.DataBean bean);
    }
}
