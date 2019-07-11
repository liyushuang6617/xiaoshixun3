package com.example.num3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.num3.R;
import com.example.num3.bean.ZhihuRibaoBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class RlvZhihuF1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<ZhihuRibaoBean.StoriesBean> banlist;
    private ArrayList<ZhihuRibaoBean.TopStoriesBean> artlist;

    public RlvZhihuF1Adapter(Context context, ArrayList<ZhihuRibaoBean.StoriesBean> banlist, ArrayList<ZhihuRibaoBean.TopStoriesBean> artlist) {
        this.context = context;
        this.banlist = banlist;
        this.artlist = artlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            View view = View.inflate(context, R.layout.zhihuribao_item1, null);
            return new ViewHolder1(view);
        } else if (i == 1) {
            View view = View.inflate(context, R.layout.zhihuribao_item2, null);
            return new ViewHolder2(view);
        } else {
            View view = View.inflate(context, R.layout.zhihuribao_item3, null);
            return new ViewHolder3(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == 0) {
            ViewHolder1 viewHolder1 = (ViewHolder1) viewHolder;
            viewHolder1.banner.setImages(banlist);
            viewHolder1.banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    ZhihuRibaoBean.StoriesBean p = (ZhihuRibaoBean.StoriesBean) path;
                    Glide.with(context).load(p.getImages()).placeholder(R.mipmap.ic_launcher).into(imageView);
                }
            }).start();
        } else if (getItemViewType(i) == 1) {
            ViewHolder2 viewHolder2 = (ViewHolder2) viewHolder;
            viewHolder2.tv.setText("今日热闻");
        } else {
            ViewHolder3 viewHolder3 = (ViewHolder3) viewHolder;
            int pos = 0;
            if (banlist.size() > 0) {
                pos = i - 1;
            } else {
                pos = i;
            }
            viewHolder3.tv2.setText(artlist.get(pos).getTitle());
            Glide.with(context).load(artlist.get(pos).getImage()).placeholder(R.mipmap.ic_launcher).into(viewHolder3.iv);
        }
    }

    @Override
    public int getItemCount() {
        if (banlist.size() > 0) {
            return artlist.size() + 1;
        } else {
            return artlist.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        Banner banner;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.ban);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView tv;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }

    class ViewHolder3 extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv2;

        public ViewHolder3(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv2 = itemView.findViewById(R.id.tv2);

        }
    }
}
