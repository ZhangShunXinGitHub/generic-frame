package com.generic.web.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class ThemeInfo {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
