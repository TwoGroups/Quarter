package com.erzu.quarter.model.bean;

/**
 * Created by samsung on 2018/1/26.
 */

public class EventBean {
    private String cover;
    private String name;
    private String url;

    public EventBean(String cover, String name, String url) {
        this.cover = cover;
        this.name = name;
        this.url = url;
    }

    public String getCover() {
        return cover;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
