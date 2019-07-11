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
import com.example.date.bean.DateBean;
import com.example.date.bean.DayNewsBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class RlvZhihuF1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int BANNER = 0;
    private static final int DATE = 1;
    private static final int ITEM = 2;

    private Context context;
    private ArrayList<DateBean.StoriesBean> list;
    private ArrayList<DayNewsBean.StoriesBean> artlist;
    private ArrayList<DayNewsBean.TopStoriesBean> banlist;

    public RlvZhihuF1Adapter(Context context, ArrayList<DateBean.StoriesBean> list
            , ArrayList<DayNewsBean.StoriesBean> artlist, ArrayList<DayNewsBean.TopStoriesBean> banlist) {
        this.context = context;
        this.list = list;
        this.artlist = artlist;
        this.banlist = banlist;
    }

    boolean isBefore;
    String title = "今日热闻";

    public void setIsbefore(boolean isBefore,String title){
        this.isBefore = isBefore;
        this.title = title;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i) {
            case BANNER:
                return new ViewHolder1(View.inflate(context, R.layout.rb_item1, null));
            case DATE:
                return new ViewHolder2(View.inflate(context, R.layout.rb_item2, null));
            case ITEM:
                return new ViewHolder3(View.inflate(context, R.layout.rb_item3, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (!isBefore) {
            if (viewHolder instanceof ViewHolder1) {
                ViewHolder1 viewHolder1 = (ViewHolder1) viewHolder;
                viewHolder1.ban.setImages(banlist)
                        .setImageLoader(new ImageLoader() {
                            @Override
                            public void displayImage(Context context, Object path, ImageView imageView) {
                                DayNewsBean.TopStoriesBean topStoriesBean = (DayNewsBean.TopStoriesBean) path;
                                Glide.with(context).load(topStoriesBean.getImage()).into(imageView);
                            }
                        }).start();
            } else if (viewHolder instanceof ViewHolder2) {
                ViewHolder2 viewHolder2 = (ViewHolder2) viewHolder;
                viewHolder2.rbtv.setText(title);
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

                ViewHolder3 viewHolder3 = (ViewHolder3) viewHolder;
                DayNewsBean.StoriesBean storiesBean = artlist.get(i);
                if (storiesBean.getImages() != null && storiesBean.getImages().size() > 0) {
                    Glide.with(context).load(storiesBean.getImages().get(0)).into(viewHolder3.rbiv);
                }
                viewHolder3.rbtv2.setText(storiesBean.getTitle());
            }
        } else {
            if (viewHolder instanceof ViewHolder2) {
                ViewHolder2 viewHolder2 = (ViewHolder2) viewHolder;
                viewHolder2.rbtv.setText(title);
            } else {
                if (title != null) {
                    i = i - 1;
                }
                if (list.size() <= 0) {
                    return;
                }
                ViewHolder3 viewHolder3 = (ViewHolder3) viewHolder;
                DateBean.StoriesBean storiesBean = list.get(i);
                if (storiesBean.getImages() != null && storiesBean.getImages().size() > 0) {
                    Glide.with(context).load(storiesBean.getImages().get(0)).into(viewHolder3.rbiv);
                }
                viewHolder3.rbtv2.setText(storiesBean.getTitle());

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

    class ViewHolder1 extends RecyclerView.ViewHolder {
        Banner ban;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            ban = itemView.findViewById(R.id.ban);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView rbtv;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            rbtv = itemView.findViewById(R.id.rbtv);
        }
    }

    class ViewHolder3 extends RecyclerView.ViewHolder {
        ImageView rbiv;
        TextView rbtv2;

        public ViewHolder3(@NonNull View itemView) {
            super(itemView);
            rbiv = itemView.findViewById(R.id.rbiv);
            rbtv2 = itemView.findViewById(R.id.rbtv2);
        }
    }
}
