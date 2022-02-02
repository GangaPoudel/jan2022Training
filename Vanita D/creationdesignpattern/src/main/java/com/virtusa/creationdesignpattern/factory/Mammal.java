package com.virtusa.creationdesignpattern.factory;


//In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface.
//FactoryPatternDemo, our demo class will use ShapeFactory to get a Shape object. It will pass information (Cat / dog / gorilla) to ShapeFactory to get the type of object it needs.
public interface Mammal {
	void sayName();
}
