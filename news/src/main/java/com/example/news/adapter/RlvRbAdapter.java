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
import com.example.news.bean.RiBaoBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvRbAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<RiBaoBean.StoriesBean> banlist;
    private ArrayList<RiBaoBean.TopStoriesBean> artlist;

    public RlvRbAdapter(Context context, ArrayList<RiBaoBean.StoriesBean> banlist,
                        ArrayList<RiBaoBean.TopStoriesBean> artlist) {
        this.context = context;
        this.banlist = banlist;
        this.artlist = artlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            View view = View.inflate(context, R.layout.rb_item1, null);
            return new ViewHodler1(view);
        } else if (i == 1) {
            View view = View.inflate(context, R.layout.rb_item2, null);
            return new ViewHodler2(view);
        } else {
            View view = View.inflate(context, R.layout.rb_item3, null);
            return new ViewHodler3(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == 0) {
            ViewHodler1 viewHodler1 = (ViewHodler1) viewHolder;
            viewHodler1.ban.setImages(banlist).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    RiBaoBean.StoriesBean p = (RiBaoBean.StoriesBean) path;
                    Glide.with(context).load(p.getImages()).placeholder(R.mipmap.ic_launcher).into(imageView);
                }
            }).start();
        } else if (getItemViewType(i) == 1) {
            ViewHodler2 viewHodler2 = (ViewHodler2) viewHolder;
            viewHodler2.rbtv.setText("最新日报");
        } else {
            ViewHodler3 viewHodler3 = (ViewHodler3) viewHolder;
            int pos = 0;
            if (banlist.size() > 0) {
                pos = i - 1;
            } else {
                pos = i;
            }
            viewHodler3.rbtv2.setText(artlist.get(pos).getTitle());
            Glide.with(context).load(artlist.get(pos).getImage()).placeholder(R.mipmap.ic_launcher).into(viewHodler3.rbiv);
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
//        return super.getItemViewType(position);
    }

    class ViewHodler1 extends RecyclerView.ViewHolder {

        @BindView(R.id.ban)
        Banner ban;

        public ViewHodler1(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class ViewHodler2 extends RecyclerView.ViewHolder {

        @BindView(R.id.rbtv)
        TextView rbtv;

        public ViewHodler2(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class ViewHodler3 extends RecyclerView.ViewHolder {

        @BindView(R.id.rbiv)
        ImageView rbiv;
        @BindView(R.id.rbtv2)
        TextView rbtv2;

        public ViewHodler3(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
