package com.virtusa.creationdesignpattern.proxy;
//this class will only be called if required as its implementation is costly
public class ExpensiveMethodImp implements ExpensiveMethod{
	public ExpensiveMethodImp() {
		veryCostlyMethod();
	}
	public void sayHello() {
		System.out.println("processing is done");
	}
	//we are keeping this method private so noone can call it from outside
	private void veryCostlyMethod() {
		System.out.println("Calling a expensive method");
	}
}
