package com.example.dao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class ListBean {

    @Id(autoincrement = true)
    private Long id;

    @Property
    private String title;

    @Property
    private String collect_num;

    @Property
    private String pic;

    @Generated(hash = 593424774)
    public ListBean(Long id, String title, String collect_num, String pic) {
        this.id = id;
        this.title = title;
        this.collect_num = collect_num;
        this.pic = pic;
    }

    @Generated(hash = 777734033)
    public ListBean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCollect_num() {
        return this.collect_num;
    }

    public void setCollect_num(String collect_num) {
        this.collect_num = collect_num;
    }

    public String getPic() {
        return this.pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


}
