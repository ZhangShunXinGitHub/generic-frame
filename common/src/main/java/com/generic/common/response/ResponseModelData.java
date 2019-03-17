package com.generic.common.response;

import com.generic.common.constant.ReturnMsg;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseModelData extends ResponseModel {
    private Object data;
    public ResponseModelData(ReturnMsg returnMsg){
        setCode(returnMsg.getCode());
        setMsg(returnMsg.getMsg());
    }
}
