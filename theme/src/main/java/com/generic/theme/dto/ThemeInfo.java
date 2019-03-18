package com.generic.theme.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class ThemeInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    public ThemeInfo(String title, String content){
        this.title=title;
        this.content=content;
    }
    protected ThemeInfo(){}
}
