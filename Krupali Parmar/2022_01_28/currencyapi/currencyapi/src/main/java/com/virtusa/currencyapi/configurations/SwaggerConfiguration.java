package com.virtusa.currencyapi.configurations;

import java.util.Collections;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

//http://localhost:XXXX/swagger-ui.html


@Configuration
@EnableSwagger2WebMvc
@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {
	// public static final String AUTHORIZATION_HEADER = "Authorization";
	// public static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";
	 @Bean
	    public Docket apiDocketcategoryparamv10() {
	        return new Docket(DocumentationType.SWAGGER_2)
	        		.groupName("currency-api-param-1.0")
	                .select()
	                .apis(RequestHandlerSelectors
	                        .basePackage("com.virtusa.currencyapi"))
	                .paths(PathSelectors.any())
	                .build()
	                .apiInfo(getApiInfo())
	                .forCodeGeneration(true)
	                .genericModelSubstitutes(ResponseEntity.class)
	                .ignoredParameterTypes(Pageable.class)
	                .ignoredParameterTypes(java.sql.Date.class)
	                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
	                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
	                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
	              //  .securityContexts(Lists.newArrayList(securityContext()))
	               // .securitySchemes(Lists.newArrayList(apiKey()))
	                .useDefaultResponseMessages(false);
	    }
 
  private ApiInfo getApiInfo() {
      return new ApiInfo(
              "Trader API",
              "App to demonstrate API Documentation",
              "0.0.1-SNAPSHOT",
              "Terms of Service",
              new Contact("Parameswari",
                      "https://blog.eswari.in",
                      "parameswaribala@gmail.com"),
              "OSS License",
              "https://blog.eswari.in",
              Collections.emptyList());
  }
}