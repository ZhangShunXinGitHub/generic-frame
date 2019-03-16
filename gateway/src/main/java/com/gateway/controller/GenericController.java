package com.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericController {
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
