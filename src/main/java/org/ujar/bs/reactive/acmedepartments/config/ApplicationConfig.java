package org.ujar.bs.reactive.acmedepartments.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.ujar.boot.starter.logbook.LogbookJsonBodyFilter;
import org.ujar.boot.starter.logbook.LogbookResponseOnStatus;

@Configuration
@LogbookResponseOnStatus
@LogbookJsonBodyFilter
@EnableTransactionManagement
@EnableConfigurationProperties({ProgramBuildInfoProperties.class, JwtTokenProperties.class})
class ApplicationConfig {

}
