package com.generic.serverMysql.controller;

import com.generic.common.response.ResponseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/hello")
    public ResponseModel hello(){
        return new ResponseModel("002000","server-mysql-user");
    }
}
