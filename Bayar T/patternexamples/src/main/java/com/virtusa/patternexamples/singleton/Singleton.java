package com.virtusa.patternexamples.singleton;

public class Singleton {
	
	private static Singleton unique;
	private Singleton() {};
	
	public static Singleton getSingleton() {
		if(unique == null) {
			unique = new Singleton();
		}
		return unique;
		
	}

}
