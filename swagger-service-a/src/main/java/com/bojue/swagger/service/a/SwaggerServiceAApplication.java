package com.bojue.swagger.service.a;

import com.spring4all.swagger.EnableSwagger2Doc;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2Doc
public class SwaggerServiceAApplication {

  public static void main(String[] args) {
    SpringApplication.run(SwaggerServiceAApplication.class,args);
  }

  @RestController
  class AaaController {
      @Autowired
      private DiscoveryClient discoveryClient;

      @ApiOperation(value="获取服务列表1",tags="服务列表  tags1")
      @GetMapping("/service-a")
      public String dc(){
        List<String> services = discoveryClient.getServices();
        return services.toString();
      }
  }

}
