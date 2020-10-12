package kz.greetgo.cash_management_service.configurations;

import java.util.Collections;
import kz.greetgo.cash_management_service.Application;
import kz.greetgo.cash_management_service.web.rest.BeanScannerController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration implements WebMvcConfigurer {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage(BeanScannerController.class.getPackage().getName()))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo());
  }


  private static ApiInfo apiInfo() {
    return new ApiInfo(Application.class.getPackage().getSpecificationTitle(),
                       "REST API for AIX On Boarding",
                       Application.class.getPackage().getSpecificationVersion(),
                       "",
                       null,
                       "",
                       "",
                       Collections.emptyList());
  }


}
