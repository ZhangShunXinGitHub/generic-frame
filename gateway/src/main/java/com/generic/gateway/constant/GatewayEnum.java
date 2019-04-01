package com.generic.gateway.constant;

import com.generic.common.constant.ReturnMsg;
import lombok.Getter;

@Getter
public enum GatewayEnum implements ReturnMsg {
    TOKEN_VERIFY_FAILE("000401","token verify fail"),
    HYSTRIX_RUNTIME_EXCEPTION("000002","服务器繁忙，请稍后再试"),
    FEIGN_ERROR("000005","feign调用异常"),
    SUCCESS("000000","success");

    private String code;
    private String msg;

    private GatewayEnum(String code, String msg){
        this.code=code;
        this.msg=msg;
    }


}
