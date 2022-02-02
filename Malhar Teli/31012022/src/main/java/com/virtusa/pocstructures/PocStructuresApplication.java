package com.virtusa.pocstructures;

import com.virtusa.pocstructures.bridge.colors.Blue;
import com.virtusa.pocstructures.bridge.colors.Red;
import com.virtusa.pocstructures.bridge.shapes.Circle;
import com.virtusa.pocstructures.bridge.shapes.Square;
import com.virtusa.pocstructures.factory.Car;
import com.virtusa.pocstructures.factory.Factory;
import com.virtusa.pocstructures.factory.Moped;
import com.virtusa.pocstructures.factory.Motorcycle;
import com.virtusa.pocstructures.observable.Observable;
import com.virtusa.pocstructures.observable.Observer;
import com.virtusa.pocstructures.proxy.Proxy;
import com.virtusa.pocstructures.singleton.Singleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocStructuresApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocStructuresApplication.class, args);
		//PROXY
		System.out.println("###PROXY DEMONSTRATION");

		Proxy proxy = new Proxy();

		//We will now run the proxy's process method, demonstrating how Proxy runs the ExpensiveObject creation method in addition to its own.
		proxy.process();
		//We will run it again, to showcase how Proxy is using a single instance of the Expensive Object it represents to perform its operations.
		proxy.process();

		//FACTORY
		System.out.println("###FACTORY DEMONSTRATION");
		//This is a Factory
		//It will be used to construct objects of different classes.
		Factory factory = new Factory();

		//By using this Factory object, we can hide important information used to construct the resulting object
		Car car = (Car) factory.getVehicle("Car");
		Motorcycle motorcycle = (Motorcycle) factory.getVehicle("Motorcycle");
		Moped moped = (Moped) factory.getVehicle("Moped");

		System.out.println(car.build());
		System.out.println(moped.build());
		System.out.println(motorcycle.build());

		//OBSERVABLE
		System.out.println("###OBSERVABLE DEMONSTRATION");
		//In the lines below, we will demonstrate the interaction of Observable and its Observer
		Observer observer = new Observer();
		Observable observable = new Observable();
		//First, we must subscribe Observer to its Observable
		observable.addSubscriber(observer);
		//The observer's current message is its initial value.
		System.out.println("This is the initial value of observer's update: " + observer.observedUpdate);
		//Now the Observable will have an update!
		observable.setMessage("This is an important update from the Observable!");
		//With setMessage, the observable will update its observer's updates.
		System.out.println("This is the new value of observer's update: " + observer.observedUpdate);


		//BRIDGE
		System.out.println("###BRIDGE DEMONSTRATION");
		//In this example, we will see how Bridged Objects are divorced from their abstracted super class, and are allowed to create their own methods.
		//First, we start with our colors.
		Blue blueColor = new Blue();
		//Now, we create the Circle. Circle extends the class Shape, which is an abstract class.
		//Circle receives a color in its constructor.
		Circle circle = new Circle(blueColor);
		//Square also receives the same color, to showcase how its methods differ from Circle's, despite using the same Color.
		Square square = new Square(blueColor);
		//Now, we can print out the result of Circle's methods.
		System.out.println("Circle's draw method results in: "+ circle.draw());
		//Now we can check out Square's draw method!
		System.out.println("Square's draw method results in: "+ square.draw());


		System.out.println("###SINGLETON DEMONSTRATION");
		//SINGLETON

		//In the lines below, we will get our singleton's one and only instance, and print out the randomNumber it has selected.
		Singleton singleton = Singleton.getInstance();

		System.out.println("This is the singleton's only number: " + String.valueOf(singleton.getRandomNumber()));
		// To demonstrate how this Singleton works, I will also bring it up from the Observable class
		System.out.println("This is the value of singleton in the Observable class " + String.valueOf(observable.singleton.getRandomNumber()));
		// ... and the Proxy class
		System.out.println("This is the value of singleton in the Proxy class: " + String.valueOf(proxy.singleton.getRandomNumber()));
		// ... and the Factory class
		System.out.println("This is the value of singleton in the Factor class: " + String.valueOf(factory.singleton.getRandomNumber()));
	}

}
