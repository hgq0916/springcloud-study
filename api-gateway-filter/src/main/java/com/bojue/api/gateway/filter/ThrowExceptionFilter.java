package com.bojue.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.http.HttpStatus;

public class ThrowExceptionFilter extends ZuulFilter {

    protected Logger logger = LoggerFactory.getLogger(ThrowExceptionFilter.class);

    @Override
    public String filterType() {
        //return "pre";
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        logger.info("进入ThrowExceptionFilter run方法...");
        /*try{*/
            doSomeThing();
       /* }catch (Exception e){
            throw new ZuulRuntimeException(e);
        }*/

        return null;
    }

    private void doSomeThing() {
        throw new RuntimeException("手动抛出异常");
    }
}
