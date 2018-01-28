package com.erzu.quarter.model.bean;

import java.util.List;

/**
 * Created by lenovo on 2018/1/27.
 */

public class SearchInterstedBean {
//https://www.zhaoapi.cn/quarter/randomFriends?source=android&appVersion=101

    /**
     * msg : 请求成功
     * code : 1
     * data : [{"age":null,"appkey":"d6a3a2b06f07e9ee","appsecret":"15ED7AE3DBE8FEC3E1076C26830659F1","createtime":"2017-12-23T10:53:28","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13958408687","money":null,"nickname":null,"password":"571AF61A65C8AF3C77FEBDE13E5E6C2F","praiseNum":null,"token":null,"uid":7290,"userId":null,"username":"13958408687"},{"age":null,"appkey":"a56a1cb93397bc67","appsecret":"821C5C9C0184F0840720521BB1D8E0F0","createtime":"2017-12-23T10:53:29","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13950162916","money":null,"nickname":null,"password":"EEAD2E8D3183F82C7A9CB56855F8E77D","praiseNum":null,"token":null,"uid":7291,"userId":null,"username":"13950162916"},{"age":null,"appkey":"e76ccfa73c5a540d","appsecret":"915024CC47E2315B4AD34E7602DB250F","createtime":"2017-12-23T10:53:29","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13910148333","money":null,"nickname":null,"password":"465D3D6C330FDD15E3FCB9EAEFEE8E74","praiseNum":null,"token":null,"uid":7292,"userId":null,"username":"13910148333"},{"age":null,"appkey":"01b3931e8d94baf2","appsecret":"4CE7759A4BFD7933467CDAA171C487D1","createtime":"2017-12-23T10:53:29","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13956727959","money":null,"nickname":null,"password":"FA6440E7D3AEE13588606A0702403836","praiseNum":null,"token":null,"uid":7293,"userId":null,"username":"13956727959"},{"age":null,"appkey":"b224b7bfa73d4cb0","appsecret":"33D6A3303A640DFBDD45AC29411CE2A9","createtime":"2017-12-23T10:53:29","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13986944953","money":null,"nickname":null,"password":"1540D441D0C0A203109E7E7C713F4B7D","praiseNum":null,"token":null,"uid":7294,"userId":null,"username":"13986944953"},{"age":null,"appkey":"910572bd6803da3f","appsecret":"B674C784308BFDFC7CED00B6159A3F25","createtime":"2017-12-23T10:53:29","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13931655867","money":null,"nickname":null,"password":"F4B9EF3098CCCDC804785B06C65ACD74","praiseNum":null,"token":null,"uid":7295,"userId":null,"username":"13931655867"},{"age":null,"appkey":"88c30cc40e5e7b7d","appsecret":"0804FAB0574F1A7E9F3D3885521ED47A","createtime":"2017-12-23T10:53:30","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13927208594","money":null,"nickname":null,"password":"E39AD9C4ACEF33DC5ED558E187180C5F","praiseNum":null,"token":null,"uid":7296,"userId":null,"username":"13927208594"},{"age":null,"appkey":"b535b78e681c11b0","appsecret":"143551D8E1038FCBDCC171B9CBCF0323","createtime":"2017-12-23T10:53:30","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13921388560","money":null,"nickname":null,"password":"1B4E59FC01A02E646CDDE227C47AFDC8","praiseNum":null,"token":null,"uid":7297,"userId":null,"username":"13921388560"},{"age":null,"appkey":"d7eb072c77a4bedd","appsecret":"4054D86F755928CAA18D74D1E4DBE8DE","createtime":"2017-12-23T10:53:30","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13947920902","money":null,"nickname":null,"password":"047EBEF0F91E5591C7432FB06D462E49","praiseNum":null,"token":null,"uid":7298,"userId":null,"username":"13947920902"},{"age":null,"appkey":"59bad383e1243f73","appsecret":"C71268B5301FCD7BAF1DE0F4164BBB51","createtime":"2017-12-23T10:53:30","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13971491585","money":null,"nickname":null,"password":"EDCD59A447F9CD86E8EA6C4DC62D4155","praiseNum":null,"token":null,"uid":7299,"userId":null,"username":"13971491585"}]
     */

    private String msg;
    private String code;
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : d6a3a2b06f07e9ee
         * appsecret : 15ED7AE3DBE8FEC3E1076C26830659F1
         * createtime : 2017-12-23T10:53:28
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 13958408687
         * money : null
         * nickname : null
         * password : 571AF61A65C8AF3C77FEBDE13E5E6C2F
         * praiseNum : null
         * token : null
         * uid : 7290
         * userId : null
         * username : 13958408687
         */

        private Object age;
        private String appkey;
        private String appsecret;
        private String createtime;
        private Object email;
        private Object fans;
        private Object follow;
        private Object gender;
        private Object icon;
        private Object latitude;
        private Object longitude;
        private String mobile;
        private Object money;
        private Object nickname;
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

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
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

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
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

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
            this.money = money;
        }

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
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
