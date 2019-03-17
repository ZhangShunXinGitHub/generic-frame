package com.generic.common.exception;

import com.generic.common.constant.ResponseEnum;
import com.generic.common.response.ResponseBuilder;
import com.generic.common.response.ResponseModel;
import com.netflix.client.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Throwable.class)
    public ResponseModel exceptionHandle(HttpServletRequest request, HttpServletResponse response, Throwable e){
        if(e instanceof ThemeInfoException){
            return ResponseBuilder.genericResponseModel(((ThemeInfoException)e).getReturnMsg());
        }
        if(e instanceof HttpMessageNotReadableException){
            return ResponseBuilder.genericResponseModel(ResponseEnum.PARAM_JSON_ERROR);
        }

        if(e instanceof BindException ){
            String errMsg=resolveBindingErrMsg(((BindException)e).getBindingResult());
            return new ResponseModel(ResponseEnum.PARAM_BIND_ERROR.getCode(),errMsg);
        }


        if( e instanceof MethodArgumentNotValidException){
            String errMsg=resolveBindingErrMsg(((MethodArgumentNotValidException)e).getBindingResult());
            return new ResponseModel(ResponseEnum.PARAM_BIND_ERROR.getCode(),errMsg);
        }

        if(feignException(e)){
            return ResponseBuilder.genericResponseModel(ResponseEnum.FEIGN_ERROR);

        }
        log.error("system Exception ",e);
        return ResponseBuilder.genericResponseModel(ResponseEnum.ERROR);
    }

    private boolean feignException(Throwable e) {
        if(e instanceof feign.FeignException || e instanceof feign.RetryableException || (e instanceof RuntimeException && e.getCause() instanceof ClientException)){
            return true;
        }
        return false;
    }

    private String resolveBindingErrMsg(BindingResult bindingResult){
        StringBuilder errMsg=new StringBuilder("param bind error: ");
        for(FieldError fieldError : bindingResult.getFieldErrors()){
            String field=fieldError.getField();
            errMsg.append("[").append(field).append("]").append(fieldError.getDefaultMessage()).append(",");
        }
        return errMsg.toString();
    }
}
