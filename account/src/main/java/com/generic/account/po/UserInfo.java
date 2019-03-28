package com.generic.account.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfo implements Serializable {
   // 这里注意一定要实现序列化接口用于序列化！redis
    private static final long serialVersionUID = 2741666018289037478L;
    private Long userId;
    private String userName;
    private String sex;
    private Integer role;
    private String institutionId;
    private String officeId;
    private String updateTime;
    private String createTime;
}
