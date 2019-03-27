package com.generic.account.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@ToString
public class QueryUsersCondDto {
    private String institutionId;
    private String officeId;
    private String startTime;
    private String endTime;

    @NotNull
    @Min(value=1)
    @Max(value=Integer.MAX_VALUE)
    private Integer pageNum;

    @NotNull
    @Min(value=1)
    @Max(value=Integer.MAX_VALUE)
    private Integer pageSize;
}
