package com.generic.account.service.impl;

import com.generic.account.constant.AccountEnum;
import com.generic.account.constant.RedisKeyPrefix;
import com.generic.account.dto.QueryUsersCondDto;
import com.generic.account.dto.UserInfoDto;
import com.generic.account.mapper.UserMapper;
import com.generic.account.po.UserInfo;
import com.generic.account.service.UserService;
import com.generic.common.constant.ReturnMsg;
import com.generic.account.vo.PageInfoVO;
import com.generic.common.service.RedisService;
import com.generic.common.utils.SnowflakeUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    //特别注意的是这里的注入，由于之前配置了redisTemplate及其子类，故需要使用@Resource注解进行！
    @Autowired
    private RedisService<String, UserInfo> redisService;
    @Autowired
    private UserMapper userMapper;

    @Override
    public ReturnMsg insertUserInfo(UserInfoDto userInfoDto) {
        Long userId= SnowflakeUtil.nextId();
        userInfoDto.setUserId(userId);
        userMapper.insertUserInfo(userInfoDto);
        log.info("insertUserInfo success {}", userInfoDto);
        return AccountEnum.SUCCESS;
    }

    @Override
    public ReturnMsg updateUserInfo(UserInfoDto userInfoDto) {
        userMapper.updateUserInfo(userInfoDto);
        log.info("updateUserInfo success {}", userInfoDto);
        String key = RedisKeyPrefix.USERINFO + userInfoDto.getUserId();
        boolean haskey = redisService.hasKey(key);
        if (haskey) {
            if (redisService.del(key)) {
                log.info("updateUserInfo success and delete userInfo from redis,userId={}", userInfoDto.getUserId());
            }
        }
        return AccountEnum.SUCCESS;
    }

    @Override
    public UserInfo queryUserInfo(Long userId) {
        String key = RedisKeyPrefix.USERINFO + userId;
        boolean hasKey = redisService.hasKey(key);
        if (hasKey) {
            UserInfo userInfo = redisService.get(key);
            if (null != userInfo) {
                log.info("queryUserInfo from redis,userInfo={}", userInfo);
                return userInfo;
            }
        }
        UserInfo userInfo = userMapper.queryUserInfo(userId);
        log.info("queryUserInfo from mysql,userInfo={}", userInfo);
        redisService.set(key, userInfo, 600, TimeUnit.SECONDS);
        return userInfo;
    }

    @Override
    public PageInfoVO<UserInfo> listUserInfo(QueryUsersCondDto queryUsersCondDto) {
        PageHelper.startPage(queryUsersCondDto.getPageNum(), queryUsersCondDto.getPageSize());
        PageHelper.orderBy("update_time desc");
        Page<UserInfo> page = userMapper.listUserInfo(queryUsersCondDto);
        PageInfoVO<UserInfo> pageInfoVO = PageInfoVO.build(page);
        log.info("listUserInfo success {}", pageInfoVO.getList());
        return pageInfoVO;
    }
}
