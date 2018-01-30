package com.erzu.quarter.model.bean;

import java.util.List;

/**
 * Created by lenovo on 2018/1/27.
 */

public class SearchBean {

    /**
     * msg : 查询成功
     * code : 0
     * data : [{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-14T08:19:47","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"161616","money":0,"nickname":"张涛","password":"123456","praiseNum":null,"token":null,"uid":212,"userId":null,"username":"161616"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2018-01-26T14:07:10","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"15652770916","money":0,"nickname":"张倩","password":"111111","praiseNum":null,"token":"AFD2772D70AF2E947EF9B0270DA1D031","uid":221,"userId":null,"username":"15652770916"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-14T10:09:57","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"13233558579","money":0,"nickname":"张鹏飞","password":"123654","praiseNum":null,"token":null,"uid":338,"userId":null,"username":"13233558579"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-14T00:00:00","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"15810207777","money":0,"nickname":"张三","password":"777777","praiseNum":null,"token":null,"uid":568,"userId":null,"username":"15810207777"},{"age":null,"appkey":"eb45ec366ca86a43","appsecret":"B68966A40CE8FB59B0B9F54B306AC14B","createtime":"2018-01-22T11:28:41","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13633232200","money":null,"nickname":"张一黑","password":"DD1256DEACB85B235769C8BAAEEA4887","praiseNum":null,"token":"CB7644F55533C06902AF19FE33B7FB06","uid":1533,"userId":null,"username":"13633232200"},{"age":null,"appkey":"d77ad140559ffb95","appsecret":"75729518571BA176E3722A36C3EF2AF8","createtime":"2017-11-20T18:21:03","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18238923149","money":null,"nickname":"张三","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"41C99BE32739CBC36A067E7A60A3B388","uid":2600,"userId":null,"username":"18238923149"},{"age":null,"appkey":"1184bbdb3de7b20a","appsecret":"1F9C4461602275474EE99697C708DB4C","createtime":"2018-01-18T09:42:52","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13691513530","money":null,"nickname":"张鹏飞136","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"C941CFF961A7C5ED6826EDBF29036F2F","uid":3386,"userId":null,"username":"13691513530"},{"age":null,"appkey":"2bfa1449085b8f43","appsecret":"7028687BA153016A6B0EA4D775F87D08","createtime":"2018-01-18T19:08:53","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15223332333","money":null,"nickname":"张心卓大美女哈哈哈哈","password":"894162ABFE100F0D8CD82405AB3D67AC","praiseNum":null,"token":"29754A9DF144D24BAAFF37C5F593367B","uid":3625,"userId":null,"username":"15223332333"},{"age":null,"appkey":"39754a741ff861d8","appsecret":"ACE2C9CA48366F319649028AEEFBF298","createtime":"2017-12-13T20:11:22","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"17611336993","money":null,"nickname":"张三","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"391804D1BCF4261530D6C86389DE711E","uid":4615,"userId":null,"username":"17611336993"},{"age":null,"appkey":"be7effb525b145be","appsecret":"01D8AE56CF2A15774956A57939E2AD54","createtime":"2018-01-20T08:34:46","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/1516090820168avatar.jpg","latitude":null,"longitude":null,"mobile":"13463080251","money":null,"nickname":"张鹏飞","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"DC879AD864D710BCAB657587725B8E41","uid":11240,"userId":null,"username":"13463080251"}]
     * page : -1
     */

    private String msg;
    private String code;
    private int page;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2017-10-14T08:19:47
         * email : null
         * fans : null
         * follow : null
         * gender : 0
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 161616
         * money : 0
         * nickname : 张涛
         * password : 123456
         * praiseNum : null
         * token : null
         * uid : 212
         * userId : null
         * username : 161616
         */

        private Object age;
        private Object appkey;
        private Object appsecret;
        private String createtime;
        private Object email;
        private Object fans;
        private Object follow;
        private int gender;
        private Object icon;
        private Object latitude;
        private Object longitude;
        private String mobile;
        private int money;
        private String nickname;
        private String password;
        private Object praiseNum;
        private Object token;
        private int uid;
        private Object userId;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public Object getAppkey() {
            return appkey;
        }

        public void setAppkey(Object appkey) {
            this.appkey = appkey;
        }

        public Object getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(Object appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getFans() {
            return fans;
        }

        public void setFans(Object fans) {
            this.fans = fans;
        }

        public Object getFollow() {
            return follow;
        }

        public void setFollow(Object follow) {
            this.follow = follow;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getToken() {
            return token;
        }

        public void setToken(Object token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
