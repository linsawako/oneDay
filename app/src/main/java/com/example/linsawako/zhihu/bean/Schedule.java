package com.example.linsawako.zhihu.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by linsawako on 2017/2/5.
 */

public class Schedule extends DataSupport implements Serializable{

    private int id;
    private Date date;
    private String content;
    private Boolean finish;

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public Boolean getFinish() {
        return finish;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setFinish(Boolean finish) {
        this.finish = finish;
    }

    public void setId(int id) {
        this.id = id;
    }
}

