package com.hvlv.microservices.springcloudapigatewayservice.hvlvspringcloudapigatewayservice.entity;

public class Api {
    private Integer id;
    private Integer userId;
    private String user;
    private String key;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Api{" +
                "id=" + id +
                ", userId=" + userId +
                ", user='" + user + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
