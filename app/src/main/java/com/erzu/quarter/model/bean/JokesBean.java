package com.erzu.quarter.model.bean;

import java.util.List;

/**
 * Created by 超Sir on 2018/1/22.
 */

public class JokesBean {


    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"93335521","createTime":"2018-01-20T08:57:24","imgUrls":null,"jid":1044,"praiseNum":null,"shareNum":null,"uid":1703,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1514641278805head.jpg","nickname":"我的世界","praiseNum":"null"}},{"commentNum":null,"content":"好好学习","createTime":"2018-01-19T11:03:12","imgUrls":null,"jid":1043,"praiseNum":null,"shareNum":null,"uid":1059,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"哈哈","createTime":"2018-01-19T10:56:24","imgUrls":null,"jid":1042,"praiseNum":null,"shareNum":null,"uid":11788,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"墨尔本ぃ雨","praiseNum":"null"}},{"commentNum":null,"content":"好好学习","createTime":"2018-01-19T10:55:33","imgUrls":null,"jid":1041,"praiseNum":null,"shareNum":null,"uid":1059,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"来啊跌破坡头母鸡7k7k怕评论母鸡","createTime":"2018-01-19T10:55:11","imgUrls":null,"jid":1040,"praiseNum":null,"shareNum":null,"uid":11788,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"墨尔本ぃ雨","praiseNum":"null"}},{"commentNum":null,"content":"考虑诺克1测lolKKK去咯","createTime":"2018-01-19T10:46:01","imgUrls":null,"jid":1039,"praiseNum":null,"shareNum":null,"uid":11788,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"墨尔本ぃ雨","praiseNum":"null"}},{"commentNum":null,"content":"跨界石打开连接阿斯利康","createTime":"2018-01-18T20:53:06","imgUrls":null,"jid":1038,"praiseNum":null,"shareNum":null,"uid":11788,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"墨尔本ぃ雨","praiseNum":"null"}},{"commentNum":null,"content":"吴希瑞！！八维最帅经理！！！！！没有之一！！！！！！！！啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊！！！！！","createTime":"2018-01-18T20:52:28","imgUrls":null,"jid":1037,"praiseNum":null,"shareNum":null,"uid":3625,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"张心卓大美女哈哈哈哈","praiseNum":"null"}},{"commentNum":null,"content":"吴希瑞！！！！最帅啦！！！八维最帅经理！！！！！啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊！！！！！","createTime":"2018-01-18T20:51:58","imgUrls":null,"jid":1036,"praiseNum":null,"shareNum":null,"uid":3625,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"张心卓大美女哈哈哈哈","praiseNum":"null"}},{"commentNum":null,"content":"吴希瑞！！！！最帅啦！！！八维最帅经理！！！！！啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊！！！！！","createTime":"2018-01-18T20:51:41","imgUrls":null,"jid":1035,"praiseNum":null,"shareNum":null,"uid":3625,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"张心卓大美女哈哈哈哈","praiseNum":"null"}}]
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
         * commentNum : null
         * content : 93335521
         * createTime : 2018-01-20T08:57:24
         * imgUrls : null
         * jid : 1044
         * praiseNum : null
         * shareNum : null
         * uid : 1703
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1514641278805head.jpg","nickname":"我的世界","praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private Object imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;
        private boolean isopen;

        public boolean isIsopen() {
            return isopen;
        }

        public void setIsopen(boolean isopen) {
            this.isopen = isopen;
        }

        public DataBean(boolean isopen) {
            this.isopen = isopen;
        }

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(Object imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1514641278805head.jpg
             * nickname : 我的世界
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
