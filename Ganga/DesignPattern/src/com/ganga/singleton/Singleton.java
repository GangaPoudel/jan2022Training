package com.ganga.singleton;

public class Singleton {
	public static void main(String[] args) {
		Singleton single = Singleton.getInstance();
		single.showMessage();
	}
	
	// Creating the object for Singleton
	 private static Singleton instance = new Singleton();
	
	private Singleton() {
		
	}
		 //Get the only object available
		   public static Singleton getInstance(){
		      return instance;
		   }

		   public void showMessage(){
		      System.out.println("Example of Singleton Pattern");
		   }
		
	}


