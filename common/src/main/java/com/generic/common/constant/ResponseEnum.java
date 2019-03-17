package com.generic.common.constant;

import lombok.Getter;

@Getter
public enum ResponseEnum implements ReturnMsg{
    ERROR("000001","error"),
    HYSTRIX_RUNTIME_EXCEPTION("000002","服务器繁忙，请稍后再试"),
    PARAM_JSON_ERROR("000003","参数json格式或类型解析错误"),
    PARAM_BIND_ERROR("000004","JSR303验证失败"),
    FEIGN_ERROR("000005","feign调用异常"),
    SUCCESS("000000","success");

    private String code;
    private String msg;

    private ResponseEnum(String code,String msg){
        this.code=code;
        this.msg=msg;
    }


}
