package com.generic.fileuploadclient.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class UploadFileInfo {
    @NotBlank
    private String uploadFileId;
    @NotBlank
    private String uploadFileName;
}
