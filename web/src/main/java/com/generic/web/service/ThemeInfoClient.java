package com.generic.web.service;

import com.generic.web.dto.ThemeInfo;
import com.generic.common.response.ResponseModel;
import com.generic.common.response.ResponseModelData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "theme",path = "/api",fallback = ThemeInfoClientFallback.class)
public interface ThemeInfoClient {
    @PostMapping("/saveThemeInfo")
    ResponseModel saveThemeInfo (@RequestBody ThemeInfo themeInfo);

    @GetMapping("/findAllThemeInfo")
    ResponseModelData findAllThemeInfo();
}
