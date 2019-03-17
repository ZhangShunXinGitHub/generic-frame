package com.generic.common.response;

import com.generic.common.constant.ReturnMsg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ResponseModel implements Serializable {

    private static final long serialVersionUID = -8754351313966830623L;
    private String code;
    private String msg;
    public ResponseModel(ReturnMsg returnMsg){
        this.code=returnMsg.getCode();
        this.msg=returnMsg.getMsg();
    }
}
