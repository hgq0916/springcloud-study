package com.bojue.api.gateway.swagger;

import com.spring4all.swagger.EnableSwagger2Doc;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@EnableSwagger2Doc
@SpringCloudApplication
@EnableZuulProxy
public class ApiGatewaySwaggerApplication {

  public static void main(String[] args) {
    new SpringApplicationBuilder(ApiGatewaySwaggerApplication.class).web(true).run(args);
  }

  //创建swagger配置类
  @Component
  @Primary
  class DocumentationConfig implements SwaggerResourcesProvider{

    @Override
    public List<SwaggerResource> get() {
      List<SwaggerResource> swaggerResourceList = new ArrayList<SwaggerResource>();
      swaggerResourceList.add(swaggerResource("swagger-service-a","/swagger-service-a/v2/api-docs","2.0"));
      swaggerResourceList.add(swaggerResource("swagger-service-b","/swagger-service-b/v2/api-docs","2.0"));
      return swaggerResourceList;
    }

    private SwaggerResource swaggerResource(String name, String location,String version) {
      SwaggerResource swaggerResource = new SwaggerResource();
      swaggerResource.setName(name);
      swaggerResource.setLocation(location);
      //swaggerResource.setUrl(url);
      swaggerResource.setSwaggerVersion(version);
      return swaggerResource;
    }
  }
}
