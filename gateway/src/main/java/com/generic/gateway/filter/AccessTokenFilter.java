package com.generic.gateway.filter;

import com.ctrip.framework.apollo.ConfigService;
import com.generic.common.response.ResponseModel;
import com.generic.common.utils.JsonUtils;
import com.generic.gateway.constant.GatewayEnum;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

public class AccessTokenFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessTokenFilter.class);

    /*
    pre：可以在请求被路由之前调用
    route：在路由请求时候被调用
    post：在route和error过滤器之后被调用
    error：处理请求时发生错误时被调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;//数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        return true;//过滤器开关
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        //免鉴权接口
      /*  Config config = ConfigService.getAppConfig();
        Integer defaultRequestTimeout = 200;
        Integer requestTimeout =
                config.getIntProperty("request.timeout",defaultRequestTimeout);*/
      String port=  ConfigService.getAppConfig().getProperty("server.port", "undefined");
      log.info("port:{}",port);

        String accessToken = request.getHeader("token");
        String serverToken="123456";
        if(null!=accessToken && accessToken.equals(serverToken)){
            log.info("token verify success");
            ctx.setSendZuulResponse(true);//对该请求路由
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess",true);//让下一个Filter看到上一个Filter的状态
            return null;
        }else {
            log.warn("serverToke={} but accessToken={}, token verify fail",serverToken,accessToken);
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ResponseModel responseModel=new ResponseModel(GatewayEnum.TOKEN_VERIFY_FAILE);
            String errResult= JsonUtils.objectToJson(responseModel);
            ctx.setResponseBody(errResult);
            ctx.set("isSuccess",false);
            return null;
        }
    }

}

