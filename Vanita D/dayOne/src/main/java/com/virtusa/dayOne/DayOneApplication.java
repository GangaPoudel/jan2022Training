package com.virtusa.dayOne;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.virtusa.dayOne.annotations.Dog;
import com.virtusa.dayOne.annotations.Mammal;
import com.virtusa.dayOne.configurations.Confiq;



@SpringBootApplication
public class DayOneApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DayOneApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(Confiq.class);
		ApplicationContext ctx =
			    new FileSystemXmlApplicationContext("classpath:com/virtusa/dayOne/configurations/spring-config.xml");
		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        Mammal obj = (Mammal) context.getBean("createDog");
        Mammal mammal = (Mammal) ctx.getBean("mammal");
        System.out.println( obj.getSpecies() );
        System.out.println( mammal );
       
	}
	
}