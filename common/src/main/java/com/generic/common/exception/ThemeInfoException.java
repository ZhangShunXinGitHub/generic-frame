package com.generic.common.exception;

import com.generic.common.constant.ReturnMsg;
import lombok.Getter;

@Getter
public class ThemeInfoException extends Exception{
    private ReturnMsg returnMsg;
    public ThemeInfoException(ReturnMsg returnMsg){
        this.returnMsg=returnMsg;
    }

}
