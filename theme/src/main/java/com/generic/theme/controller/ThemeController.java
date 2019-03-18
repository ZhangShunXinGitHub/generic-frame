package com.generic.theme.controller;

import com.alibaba.fastjson.JSONObject;
import com.generic.common.exception.ThemeInfoException;
import com.generic.common.response.ResponseBuilder;
import com.generic.common.response.ResponseModel;
import com.generic.theme.dto.ThemeInfo;
import com.generic.theme.service.ThemeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api")
public class ThemeController {
    @Autowired
    private ThemeService themeService;

    @GetMapping("/hello")
    public ResponseModel hello(){
        return new ResponseModel("001000","theme");
    }

    @PostMapping("/saveThemeInfo")
    public ResponseModel savaThemeInfo(@Validated @RequestBody ThemeInfo themeInfo) throws ThemeInfoException {
        log.info("param ", JSONObject.toJSONString(themeInfo));
        return ResponseBuilder.genericResponseModel(themeService.saveThemeInfo(themeInfo));
    }

    @GetMapping("/findAllThemeInfo")
    public ResponseModel findAllThemeInfo() throws ThemeInfoException {
        log.info("findAllThemeInfo");
        return ResponseBuilder.genericResponseModel(themeService.findAllThemeInfo());
    }
}
