package com.sec.db;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by Administrator on 2016/11/30.
 */
@SuppressWarnings({"JpaDataSourceORMInspection", "unused"})
@Entity
public class ChuanZhen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;

    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column(name = "年度")
    private int year = Calendar.getInstance().get(Calendar.YEAR);

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "WorkID", referencedColumnName = "WorkID")
    })
    private User user;

    public ChuanZhen() {
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public int getYear() {
        return year;
    }

    public User getUser() {
        return user;
    }

    public ChuanZhen(String content) {
        this.content = content;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        String new_cid = String.format("%03d", cid);
        return "传真" +
                (year - 2000) + '-' + new_cid +
                ":" + content;
    }
}
