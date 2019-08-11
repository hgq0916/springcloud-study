package com.bojue.trace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Trace1Application {

  protected Logger logger = LoggerFactory.getLogger(Trace1Application.class);

  public static void main(String[] args) {
    new SpringApplicationBuilder(Trace1Application.class).web(true).run(args);
  }

  @Autowired
  private RestTemplate restTemplate;

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @RequestMapping(value = "/trace-1",method = RequestMethod.GET)
  public String trace1(){

    logger.info("trace1 be called");
    return restTemplate.getForEntity("http://trace-2/trace-2",String.class).getBody();
  }

}
