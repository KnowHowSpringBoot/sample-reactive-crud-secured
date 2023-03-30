package org.ujar.webfluxcrudsecured.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@Configuration
@EnableSwagger2WebFlux
class SwaggerConfig {

  @Bean
  Docket springfoxSwaggerApiDocket(ApplicationBuildInfoProperties buildInfo) {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .pathMapping(buildInfo.relativePath());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Webflux App Demo")
        .description("Webflux App Demo")
        .version("1.0")
        .build();
  }
}
