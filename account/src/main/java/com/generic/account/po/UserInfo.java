package com.generic.account.po;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Long userId;
    private String userName;
    private String sex;
    private Integer role;
    private String institutionId;
    private String officeId;
    private String updateTime;
    private String createTime;
}
