package com.bojue.consumer.controller;

import com.bojue.consumer.service.ConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/consumer")
    public String dc(){
        System.out.println("dc被调用了");
        return consumerService.dc();
    }

}
