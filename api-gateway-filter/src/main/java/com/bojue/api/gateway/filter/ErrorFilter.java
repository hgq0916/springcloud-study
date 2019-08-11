package com.bojue.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class ErrorFilter extends ZuulFilter {

    protected Logger logger = LoggerFactory.getLogger(ErrorFilter.class);

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        Throwable throwable = requestContext.getThrowable();
        logger.error("RequestContext throwable:",throwable);
        requestContext.set("error.status_code", HttpStatus.INTERNAL_SERVER_ERROR);
        requestContext.set("error.message","服务器内部错误");
        return null;
    }
}
