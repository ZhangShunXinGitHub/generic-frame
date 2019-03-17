package com.generic.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.generic.common.exception.ThemeInfoException;
import com.generic.common.response.ResponseBuilder;
import com.generic.common.response.ResponseModel;
import com.generic.server.dto.ThemeInfo;
import com.generic.server.service.ThemeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/serverH2")
public class ThemeController {
    @Autowired
    private ThemeService themeService;
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
