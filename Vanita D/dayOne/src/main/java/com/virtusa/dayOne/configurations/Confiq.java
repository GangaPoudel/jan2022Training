package com.virtusa.dayOne.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

import com.virtusa.dayOne.annotations.Mammal;


@Configuration
@ComponentScan
@Lazy
public class Confiq {
	Mammal mammal;
	
	
	@Bean
    public Mammal createDog() {
        return new Mammal("John");
    }

    @Bean
    @Primary
    public Mammal createMammal() {
        return new Mammal("Tony");
    }
//    @Bean
//    public Mammal mammal(){
//      return new Mammal();
//    }
    
}

//Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime, for example:
//we use @Primary to give higher preference to a bean when there are multiple beans of the same type.
//When we put @Lazy annotation over the @Configuration class, it indicates that all the methods with @Bean annotation should be loaded lazily.
//with Autowire - in order to initialize a lazy bean, we reference it from another one.