package com.generic.fileuploadclient.controller;

import com.generic.common.response.ResponseModel;
import com.generic.fileuploadclient.service.Fileuploadclient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api")
public class FileuploadclientController {
    @Autowired
    private Fileuploadclient fileclientClient;
    @GetMapping("/hello")
    public ResponseModel hello(){
        return new ResponseModel("000001","fileuploadClient");
    }

/*    @PostMapping("/saveThemeInfo")
    public ResponseModel savaThemeInfo(@Validated @RequestBody UploadFileInfo themeInfo) throws Exception {
        log.info("param {}", JsonUtils.objectToJson(themeInfo));
        return fileclientClient.saveThemeInfo(themeInfo);
    }

    @GetMapping("/findAllThemeInfo")
    public ResponseModel findAllThemeInfo() throws ThemeInfoException {
        log.info("findAllThemeInfo");
        return fileclientClient.findAllThemeInfo();
    }*/
}
