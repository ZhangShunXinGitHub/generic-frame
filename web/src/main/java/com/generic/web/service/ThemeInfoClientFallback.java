package com.generic.web.service;

import com.generic.web.dto.ThemeInfo;
import com.generic.common.constant.ResponseEnum;
import com.generic.common.response.ResponseBuilder;
import com.generic.common.response.ResponseModel;
import com.generic.common.response.ResponseModelData;

public class ThemeInfoClientFallback implements ThemeInfoClient {
    @Override
    public ResponseModel saveThemeInfo(ThemeInfo themeInfo) {
        return ResponseBuilder.genericResponseModel(ResponseEnum.HYSTRIX_RUNTIME_EXCEPTION);
    }

    @Override
    public ResponseModelData findAllThemeInfo() {
        return new ResponseModelData(ResponseEnum.HYSTRIX_RUNTIME_EXCEPTION);
    }
}
