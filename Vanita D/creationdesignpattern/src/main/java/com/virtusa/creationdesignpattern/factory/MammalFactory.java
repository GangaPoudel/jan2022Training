package com.virtusa.creationdesignpattern.factory;

public class MammalFactory {
	 public Mammal getMammal(String mammal){
	      if(mammal == null){
	         return null;
	      }		
	      if(mammal.equalsIgnoreCase("CAT")){
	         return new Cat();
	         
	      } else if(mammal.equalsIgnoreCase("DOG")){
	         return new Dog();
	         
	      } else if(mammal.equalsIgnoreCase("GORILLA")){
	         return new Gorilla();
	      }
	      
	      return null;
	   }
}
