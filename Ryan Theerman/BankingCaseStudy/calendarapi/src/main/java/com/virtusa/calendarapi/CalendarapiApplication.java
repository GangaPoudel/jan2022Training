package com.virtusa.calendarapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableCaching
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class CalendarapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalendarapiApplication.class, args);
	}

}
