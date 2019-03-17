package com.generic.fileupload.controller;

import com.generic.common.response.ResponseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fileupload")
public class FileuploadController {
    @GetMapping("/hello")
    public ResponseModel hello(){
        return new ResponseModel("003000","fileupload");
    }
}
