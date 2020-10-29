package com.cs.service.impl;

import com.cs.entity.UserInfo;
import com.cs.mapper.UserInfoMapper;
import com.cs.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("service1")
public class UserInfoImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findAllUserInfo() throws Exception {
        return userInfoMapper.findAllUserInfo();
//        return null;
    }

    @Override
    public List<UserInfo> findTitleByuserName(String userName) throws Exception {
        return userInfoMapper.findTitleByuserName(userName);
//        return null;
    }

    @Override
    public int addUser(UserInfo userInfo) throws Exception {
        return userInfoMapper.addUser(userInfo);
//        return 0;
    }

    @Override
    public UserInfo findUserInfoByID(int userID) throws Exception {
        return userInfoMapper.findUserInfoByID(userID);
//        return null;
    }
}
