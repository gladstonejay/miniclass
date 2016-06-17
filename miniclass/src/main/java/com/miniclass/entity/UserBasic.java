package com.miniclass.entity;

import java.util.Date;

public class UserBasic {
    private Integer id;

    private String userId;

    private String userNname;

    private String userType;

    private String password;

    private Integer score;

    private Date registTime;

    private String province;

    private String city;

    private String county;

    private Integer status;

    private Integer autumn;

    private Integer winter;

    public Integer getAutumn() {
        return autumn;
    }

    public void setAutumn(Integer autumn) {
        this.autumn = autumn;
    }

    public Integer getWinter() {
        return winter;
    }

    public void setWinter(Integer winter) {
        this.winter = winter;
    }

    public Integer getSpring() {
        return spring;
    }

    public void setSpring(Integer spring) {
        this.spring = spring;
    }

    private Integer spring;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserNname() {
        return userNname;
    }

    public void setUserNname(String userNname) {
        this.userNname = userNname == null ? null : userNname.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }


}