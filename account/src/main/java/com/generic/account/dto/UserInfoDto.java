package com.generic.account.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ToString
public class UserInfoDto {
    @NotNull(groups = {InsertUserInfo.class})
    private Long userId;
    @NotBlank
    private String userName;
    private String sex;
    @NotNull
    private Integer role;
    @NotBlank
    private String institutionId;
    @NotBlank
    private String officeId;

    public interface InsertUserInfo{}
}
