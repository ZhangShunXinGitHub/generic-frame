package com.generic.fileuploadclient.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "fileupload",path = "/api",fallback = FileclientClientFallback.class)
public interface Fileuploadclient {
  /*  @PostMapping("/saveThemeInfo")
    ResponseModel saveThemeInfo (@RequestBody UploadFileInfo themeInfo);

    @GetMapping("/findAllThemeInfo")
    ResponseModelData findAllThemeInfo();*/
}
