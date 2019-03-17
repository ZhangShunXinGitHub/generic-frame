package com.generic.gateway.service;

import com.generic.gateway.dto.ThemeInfo;
import com.generic.common.response.ResponseModel;
import com.generic.common.response.ResponseModelData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "server-h2",path = "/serverH2",fallback = ThemeInfoClientFallback.class)
public interface ThemeInfoClient {
    @PostMapping("/saveThemeInfo")
    ResponseModel saveThemeInfo (@RequestBody ThemeInfo themeInfo);

    @GetMapping("/findAllThemeInfo")
    ResponseModelData findAllThemeInfo();
}
