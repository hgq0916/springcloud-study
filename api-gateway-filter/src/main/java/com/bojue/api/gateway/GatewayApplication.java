package com.bojue.api.gateway;

import com.bojue.api.gateway.filter.AccessFilter;
import com.bojue.api.gateway.filter.ErrorFilter;
import com.bojue.api.gateway.filter.ThrowExceptionFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class GatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(GatewayApplication.class).web(true).run(args);
    }


    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }

    @Bean
    public ThrowExceptionFilter throwExceptionFilter(){
        return new ThrowExceptionFilter();
    }
    @Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }
}
