package com.bojue.consumer.controller;

import com.bojue.consumer.client.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

   @Autowired
   private DcClient dcClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/dc")
    public String dc(){
        return dcClient.dc();
    }

}
