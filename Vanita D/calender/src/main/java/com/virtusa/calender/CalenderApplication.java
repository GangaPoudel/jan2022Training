package com.virtusa.calender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CalenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalenderApplication.class, args);
	}

}
