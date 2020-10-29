package com.cs.entity;

import java.io.Serializable;
import java.util.List;

public class UserInfo implements Serializable {

    private int userID;
    private String userName;
    private String userPass;
    private String sex;
    private int age;
    private String email;
    private List<News> newsList;
    private List<TopTitle> topTitleList;

    public List<TopTitle> getTopTitleList() {
        return topTitleList;
    }

    public void setTopTitleList(List<TopTitle> topTitleList) {
        this.topTitleList = topTitleList;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", topTitleList=" + topTitleList +
                '}';
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
