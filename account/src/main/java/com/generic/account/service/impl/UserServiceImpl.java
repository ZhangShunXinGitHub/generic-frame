package com.generic.account.service.impl;

import com.generic.account.constant.AccountEnum;
import com.generic.account.dto.QueryUsersCondDto;
import com.generic.account.dto.UserInfoDto;
import com.generic.account.mapper.UserMapper;
import com.generic.account.po.UserInfo;
import com.generic.account.service.UserService;
import com.generic.common.constant.ReturnMsg;
import com.generic.common.response.PageInfoVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ReturnMsg insertUserInfo(UserInfoDto userInfoDto) {
        userMapper.insertUserInfo(userInfoDto);
        log.info("insertUserInfo success {}",userInfoDto);
        return AccountEnum.SUCCESS;
    }

    @Override
    public ReturnMsg updateUserInfo(UserInfoDto userInfoDto) {
        userMapper.updateUserInfo(userInfoDto);
        log.info("updateUserInfo success {}",userInfoDto);
        return AccountEnum.SUCCESS;
    }

    @Override
    public UserInfo queryUserInfo(Long userId) {
        UserInfo userInfo= userMapper.queryUserInfo(userId);
        log.info("queryUserInfo success {}",userInfo);
        return userInfo;
    }

    @Override
    public PageInfoVO<UserInfo> listUserInfo(QueryUsersCondDto queryUsersCondDto) {
        PageHelper.startPage(queryUsersCondDto.getPageNum(),queryUsersCondDto.getPageSize());
        PageHelper.orderBy("update_time desc");
        Page<UserInfo> page=userMapper.listUserInfo(queryUsersCondDto);
        PageInfoVO<UserInfo> pageInfoVO=PageInfoVO.build(page);
        log.info("listUserInfo success {}",pageInfoVO.getList());
        return pageInfoVO;
    }
}
