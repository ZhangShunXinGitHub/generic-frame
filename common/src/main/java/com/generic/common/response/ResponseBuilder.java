package com.generic.common.response;

import com.generic.common.constant.ResponseEnum;
import com.generic.common.constant.ReturnMsg;

public class ResponseBuilder {
    public static ResponseModel genericResponseModel(Object object){
        ResponseModelData responseModelData=new ResponseModelData(ResponseEnum.SUCCESS);
        responseModelData.setData(object);
        return responseModelData;
    }

    public static ResponseModel genericResponseModel(ReturnMsg returnMsg){
        ResponseModel reponseModel=new ResponseModel(returnMsg);
        return reponseModel;
    }
}
