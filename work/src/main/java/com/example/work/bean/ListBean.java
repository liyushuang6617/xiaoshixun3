package com.example.work.bean;

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
    private String desc;

    @Property
    private String envelopePic;

    @Generated(hash = 1068897449)
    public ListBean(Long id, String title, String desc, String envelopePic) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.envelopePic = envelopePic;
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

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEnvelopePic() {
        return this.envelopePic;
    }

    public void setEnvelopePic(String envelopePic) {
        this.envelopePic = envelopePic;
    }
    
}
