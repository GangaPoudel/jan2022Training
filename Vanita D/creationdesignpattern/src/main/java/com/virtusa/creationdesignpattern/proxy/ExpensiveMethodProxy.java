package com.virtusa.creationdesignpattern.proxy;
//this class will only be called initially
public class ExpensiveMethodProxy implements ExpensiveMethod{
	//creating an instance of interface
	private static ExpensiveMethod expensiveMethod;
	
	public void sayHello() {
		if(expensiveMethod == null) {
			expensiveMethod = new ExpensiveMethodImp();
		}
		expensiveMethod.sayHello();
	}
	
}
