package com.generic.account.controller;

import com.alibaba.fastjson.JSONObject;
import com.generic.account.constant.RedisKeyPrefix;
import com.generic.account.dto.QueryUsersCondDto;
import com.generic.account.dto.UserInfoDto;
import com.generic.account.po.UserInfo;
import com.generic.account.service.UserService;
import com.generic.common.response.ResponseBuilder;
import com.generic.common.response.ResponseModel;
import com.generic.common.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public ResponseModel hello() {
        return new ResponseModel("002000", "account");
    }

    @PostMapping("/insertUserInfo")
    public ResponseModel insertUserInfo(@Validated(UserInfoDto.InsertUserInfo.class) @RequestBody UserInfoDto userInfoDto) {
        log.info("insertUserInfo param {}", JsonUtils.objectToJson(userInfoDto));
        return ResponseBuilder.genericResponseModel(userService.insertUserInfo(userInfoDto));
    }

    @PostMapping("/updateUserInfo")
    public ResponseModel updateUserInfo(@Validated @RequestBody UserInfoDto userInfoDto) {
        log.info("updateUserInfo param {}", JsonUtils.objectToJson(userInfoDto));
        return ResponseBuilder.genericResponseModel(userService.updateUserInfo(userInfoDto));
    }

    @PostMapping("/queryUserInfo")
    public ResponseModel queryUserInfo(@RequestParam(value = "userId", defaultValue = "0") Long userId) {
        log.info("queryUserInfo param userId= {}", userId);
        return ResponseBuilder.genericResponseModel(userService.queryUserInfo(userId));
    }

    @PostMapping("/listUserInfo")
    public ResponseModel listUserInfo(@Validated @RequestBody QueryUsersCondDto queryUsersCondDto) {
        log.info("listUserInfo param {}", JsonUtils.objectToJson(queryUsersCondDto));
        return ResponseBuilder.genericResponseModel(userService.listUserInfo(queryUsersCondDto));
    }

    public static void main(String[] args) {
        UserInfoDto userInfoDto = new UserInfoDto();
        QueryUsersCondDto queryUsersCondDto = new QueryUsersCondDto();
        System.out.println(JsonUtils.objectToJson(userInfoDto));
        System.out.println(JsonUtils.objectToJson(queryUsersCondDto));
    }

}
