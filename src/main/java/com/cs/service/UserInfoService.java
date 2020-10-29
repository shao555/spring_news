package com.cs.service;

import com.cs.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    //查询用户表所有记录 select * from userinfo
    public List<UserInfo> findAllUserInfo() throws Exception;

    //根据用户名字查询用户发布了那些新闻标题
    public List<UserInfo> findTitleByuserName(String userName) throws Exception;

    //添加用户
    public int addUser(UserInfo userInfo) throws Exception;

    //根据用户ID查询所有记录
    public UserInfo findUserInfoByID(int userID) throws Exception;

}
