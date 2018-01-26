package com.erzu.quarter.model.bean;

/**
 * Created by samsung on 2018/1/26.
 */

public class EventBeanLogin {
    private String pic;
    private String nickName;

    public EventBeanLogin(String pic, String nickName) {
        this.pic = pic;
        this.nickName = nickName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
