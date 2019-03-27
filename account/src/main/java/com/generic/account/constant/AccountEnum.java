package com.generic.account.constant;

import com.generic.common.constant.ReturnMsg;
import lombok.Getter;

@Getter
public enum  AccountEnum implements ReturnMsg {
    SUCCESS("000200","success"),
    ERROR("000200","success");
    private String code;
    private String msg;

    private AccountEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
