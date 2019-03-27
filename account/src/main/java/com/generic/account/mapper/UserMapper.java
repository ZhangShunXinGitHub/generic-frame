package com.generic.account.mapper;

import com.generic.account.dto.QueryUsersCondDto;
import com.generic.account.dto.UserInfoDto;
import com.generic.account.po.UserInfo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    Integer insertUserInfo(UserInfoDto userInfoDto);
    Integer updateUserInfo(UserInfoDto userInfoDto);
    UserInfo queryUserInfo(@Param("userId") Long userId);
    Page<UserInfo> listUserInfo(QueryUsersCondDto queryUsersCondDto);
}
