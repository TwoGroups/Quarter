package com.erzu.quarter.model.bean;

/**
 * Created by samsung on 2018/1/26.
 */

public class EventBean {
    private String cover;
    private String name;

    public EventBean(String cover, String name) {
        this.cover = cover;
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public String getName() {
        return name;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setName(String name) {
        this.name = name;
    }
}
