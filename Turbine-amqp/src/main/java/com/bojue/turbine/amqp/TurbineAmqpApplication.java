package com.bojue.turbine.amqp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbineStream//启用turbinestream配置
public class TurbineAmqpApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TurbineAmqpApplication.class).web(true).run(args);
    }
}
