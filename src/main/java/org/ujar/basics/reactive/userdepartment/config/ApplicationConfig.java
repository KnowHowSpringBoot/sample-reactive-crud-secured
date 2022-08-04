package org.ujar.basics.reactive.userdepartment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.ujar.boot.starter.logbook.LogbookJsonBodyFilter;
import org.ujar.boot.starter.logbook.LogbookResponseOnStatus;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@Configuration
@LogbookResponseOnStatus
@LogbookJsonBodyFilter
@EnableTransactionManagement
@EnableSwagger2WebFlux
class ApplicationConfig {

}
