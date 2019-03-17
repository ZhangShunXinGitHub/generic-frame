package com.generic.gateway.controller;

import com.generic.gateway.dto.ThemeInfo;
import com.generic.gateway.service.ThemeInfoClient;
import com.generic.common.exception.ThemeInfoException;
import com.generic.common.response.ResponseModel;
import com.generic.common.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/gateway")
public class GatewayController {
    @Autowired
    private ThemeInfoClient themeInfoClient;
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
    @PostMapping("/saveThemeInfo")
    public ResponseModel savaThemeInfo(@Validated @RequestBody ThemeInfo themeInfo) throws Exception {
        log.info("param {}", JsonUtils.objectToJson(themeInfo));
        return themeInfoClient.saveThemeInfo(themeInfo);
    }

    @GetMapping("/findAllThemeInfo")
    public ResponseModel findAllThemeInfo() throws ThemeInfoException {
        log.info("findAllThemeInfo");
        return themeInfoClient.findAllThemeInfo();
    }
}
