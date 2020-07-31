package com.paulo.javabase.module4.task4;

import java.io.Serializable;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: com.paulo.javabase.module4.task4
 * @date:2020/7/31
 */
public class UserMessage implements Serializable {
    private static final long serialVersionUID = 3943400951794133240L;

    /**
     * 消息类型
     */
    private String type;

    /**
     * 用户信息
     */
    private User user;

    public UserMessage() {
    }

    public UserMessage(String type, User user) {
        this.type = type;
        this.user = user;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static class User implements Serializable{
        private static final long serialVersionUID = 136138671947175340L;
        /**
         * 用户名
         */
        private String userName;
        /**
         * 密码
         */
        private String password;

        public User() {
        }

        public User(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
