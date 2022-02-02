package com.virtusa.creationdesignpattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.virtusa.creationdesignpattern.builder.Customer;
import com.virtusa.creationdesignpattern.factory.Mammal;
import com.virtusa.creationdesignpattern.factory.MammalFactory;
import com.virtusa.creationdesignpattern.observable.Book;
import com.virtusa.creationdesignpattern.observable.Liker;
import com.virtusa.creationdesignpattern.proxy.ExpensiveMethod;
import com.virtusa.creationdesignpattern.proxy.ExpensiveMethodProxy;
import com.virtusa.creationdesignpattern.singleton.SingleCar;

@SpringBootApplication
public class CreationdesignpatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreationdesignpatternApplication.class, args);
		
		//Compile Time Error: The constructor SingleObject() is not visible
		//SingleCar object =new SingleCar();
		
		SingleCar object = SingleCar.getInstance();
		object.showMessage();
		
		//proxy
		ExpensiveMethod expensiveMethod = new ExpensiveMethodProxy();
		expensiveMethod.sayHello();
		expensiveMethod.sayHello();
		
		
		//factory
		MammalFactory mammalFactory = new MammalFactory();
		 //get an object of Cat and call its sayName method.
	      Mammal mammal1 = mammalFactory.getMammal("CAT");
	      mammal1.sayName();

//	    //get an object of Dog and call its SayName method.
	      Mammal mammal2 = mammalFactory.getMammal("GORILLA");
	      mammal2.sayName();
//
//	    //get an object of Cat and call its sayName method.
	      Mammal mammal3 = mammalFactory.getMammal("DOG");
	      mammal3.sayName();
	      
	      
	      //builder design pattern
	    //I dont want to set all parameter
	    //I should know the sequence of parameter when creating a new customer
	    //In builder we are setting the value, and getting the same instance back
	    //while creating customer this way, sequence of parameter is not important
	      Customer customer = new Customer();
	      customer.setAge("12");
	      customer.setName("sam");
	      customer.printDetails();
	      
	      
	      //observable design pattern
	      Book book = new Book("Abc");
	      Liker liker1 = new Liker("vinita");
	      Liker liker2 = new Liker("vini");
	      book.addLiker(liker1);
	      book.addLiker(liker2);
	      Book book1 = new Book("xyz");
	      
	}

}
