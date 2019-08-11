package com.bojue.trace;

import javax.servlet.http.HttpServletRequest;
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
public class Trace2Application {

  protected Logger logger = LoggerFactory.getLogger(Trace2Application.class);

  public static void main(String[] args) {
    new SpringApplicationBuilder(Trace2Application.class).web(true).run(args);
  }

  @Autowired
  private RestTemplate restTemplate;

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @RequestMapping(value = "/trace-2",method = RequestMethod.GET)
  public String trace2(HttpServletRequest request){

    logger.info("trace2 be called");
    logger.info("请求跟踪："+request.getHeader("X-B3-TraceId")+","+request.getHeader("X-B3-SpanId"));
    return "trace2";
  }

}
