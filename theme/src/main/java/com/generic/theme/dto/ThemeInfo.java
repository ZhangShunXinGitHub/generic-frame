package com.generic.theme.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ThemeInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String title;
    private String content;
    public ThemeInfo(String title, String content){
        this.title=title;
        this.content=content;
    }
    protected ThemeInfo(){}
}
