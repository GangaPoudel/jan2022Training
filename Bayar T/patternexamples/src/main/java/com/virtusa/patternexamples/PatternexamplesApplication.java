package com.virtusa.patternexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.virtusa.patternexamples.factory.Factory;
import com.virtusa.patternexamples.factory.Shape;
import com.virtusa.patternexamples.factory.Square;
import com.virtusa.patternexamples.observer.News;
import com.virtusa.patternexamples.observer.NewsChannel;
import com.virtusa.patternexamples.proxy.Internet;
import com.virtusa.patternexamples.proxy.Proxy;
import com.virtusa.patternexamples.proxy.WorldWideWeb;
import com.virtusa.patternexamples.singleton.Singleton;

@SpringBootApplication
public class PatternexamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatternexamplesApplication.class, args);
		
		//Singleton
		Singleton singleton = Singleton.getSingleton();
		System.out.println(singleton.hashCode());
		
		//Factory
		Factory factory = new Factory();
		
		Shape shape = factory.getShape("circle");
		shape.getCorners();
		Square square = (Square) factory.getShape("square");
		square.getCorners();
		
		//Proxy
		Internet internet = new Proxy("a");
		internet.connect();
		
		//Builder
		com.virtusa.patternexamples.builder.Character charac = new com.virtusa.patternexamples.builder.Character();
		charac.setId(3).setName("hey").setStrength(5);
		charac.printAll();
		
		//Observable
		News observable = new News();
		NewsChannel observer = new NewsChannel();
		observable.addObserver(observer);
		observable.setNews("breaking news");
		System.out.println(observer.getNews());
		
		//Singleton check
		Singleton sing = Singleton.getSingleton();
		System.out.println(sing.hashCode());
	}

}
