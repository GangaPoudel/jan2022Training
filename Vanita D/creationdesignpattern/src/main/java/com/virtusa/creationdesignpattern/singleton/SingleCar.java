package com.virtusa.creationdesignpattern.singleton;

public class SingleCar {
	//creating only one instance of this class
	private static SingleCar instance= new SingleCar();
	
	//Here we are creating a private constructor// so can not be accesses outside this class
	private SingleCar() {
		
	}
	//getter method to get single instance
	public static SingleCar getInstance() {
		return instance;
	}
	public void showMessage(){
	      System.out.println("Singleton is working!");
	   }
}
