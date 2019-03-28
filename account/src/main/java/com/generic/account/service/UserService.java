package com.generic.account.service;

import com.generic.account.dto.QueryUsersCondDto;
import com.generic.account.dto.UserInfoDto;
import com.generic.account.po.UserInfo;
import com.generic.common.constant.ReturnMsg;
import com.generic.account.vo.PageInfoVO;

public interface UserService {
    ReturnMsg insertUserInfo(UserInfoDto userInfoDto);
    ReturnMsg updateUserInfo(UserInfoDto userInfoDto);
    UserInfo queryUserInfo( Long userId);
    PageInfoVO<UserInfo> listUserInfo(QueryUsersCondDto queryUsersCondDto);
}
