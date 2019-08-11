package com.bojue.eureka_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/dc")
    public String dc(){
        /*try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }


}
