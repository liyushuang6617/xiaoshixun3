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
import com.example.news.bean.DataBean;
import com.example.news.bean.RiBaoBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int BANNER = 0;
    private static final int DATE = 1;
    private static final int ITEM = 2;

    private Context context;
    private ArrayList<DataBean.StoriesBean> list;
    private ArrayList<RiBaoBean.TopStoriesBean> banlist;
    private ArrayList<RiBaoBean.StoriesBean> artlist;

    public void setIsBefore(boolean before,String title) {
        isBefore = before;
        this.title = title;
    }

    public void refreshDate(String title) {

        if (title != null) {
            this.title = title;

        }
    }

    public RlvDataAdapter(Context context, ArrayList<DataBean.StoriesBean> list,
                          ArrayList<RiBaoBean.StoriesBean> artlist, ArrayList<RiBaoBean.TopStoriesBean> banlist) {
        this.context = context;
        this.list = list;
        this.banlist = banlist;
        this.artlist = artlist;
    }

    boolean isBefore;
    String title = "今日新闻";

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i) {
            case BANNER:
                return new ViewHodler1(View.inflate(context, R.layout.rb_item1, null));
            case DATE:
                return new ViewHodler2(View.inflate(context, R.layout.rb_item2, null));
            case ITEM:
                return new ViewHodler3(View.inflate(context, R.layout.rb_item3, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (!isBefore) {
            if (viewHolder instanceof ViewHodler1) {
                ViewHodler1 viewHodler1 = (ViewHodler1) viewHolder;
                viewHodler1.ban.setImages(banlist).setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        RiBaoBean.TopStoriesBean topStoriesBean = (RiBaoBean.TopStoriesBean) path;
                        Glide.with(context).load(topStoriesBean.getImage()).into(imageView);
                    }
                }).start();
            } else if (viewHolder instanceof ViewHodler2) {
                ViewHodler2 viewHodler2 = (ViewHodler2) viewHolder;
                viewHodler2.rbtv.setText(title);
            } else {
                if (title != null) {
                    i = i - 1;
                }
                if (banlist.size() > 0) {
                    i = i - 1;
                }
                if (artlist.size() <= 0) {
                    return;
                }
                ViewHodler3 viewHodler3 = (ViewHodler3) viewHolder;
                RiBaoBean.StoriesBean storiesBean = artlist.get(i);
                if (storiesBean.getImages() != null && storiesBean.getImages().size() > 0) {
                    Glide.with(context).load(storiesBean.getImages().get(0)).into(viewHodler3.rbiv);
                }
                viewHodler3.rbtv2.setText(storiesBean.getTitle());
            }
        } else {
            if (viewHolder instanceof ViewHodler2) {
                ViewHodler2 viewHodler2 = (ViewHodler2) viewHolder;
                viewHodler2.rbtv.setText(title);
            } else {
                if (title != null) {
                    i = i - 1;
                }
                if (list.size() <= 0) {
                    return;
                }

                ViewHodler3 viewHodler3 = (ViewHodler3) viewHolder;
                DataBean.StoriesBean storiesBean = list.get(i);
                if (storiesBean.getImages() != null && storiesBean.getImages().size() > 0) {
                    Glide.with(context).load(storiesBean.getImages().get(0)).into(viewHodler3.rbiv);
                }
                viewHodler3.rbtv2.setText(storiesBean.getTitle());
            }
        }
    }

    @Override
    public int getItemCount() {
        int size = 0;
        if (!isBefore) {
            if (artlist.size() > 0) {
                size = artlist.size();
            }
            if (banlist.size() > 0) {
                size += 1;
            }
            if (title != null) {
                size += 1;
            }
        } else {
            if (list.size() > 0) {
                size = list.size();
            }
            if (title != null) {
                size += 1;
            }
        }
        return size;
    }

    @Override
    public int getItemViewType(int position) {
        if (!isBefore) {
            if (position == 0 && banlist.size() > 0) {
                return BANNER;
            } else if (position == 1 && title != null) {
                return DATE;
            } else {
                return ITEM;
            }
        } else {
            if (position == 0 && title != null) {
                return DATE;
            } else {
                return ITEM;
            }
        }
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
