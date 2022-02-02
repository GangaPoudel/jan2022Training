package com.virtusa.patternexamples.factory;

public class Square implements Shape{

	@Override
	public void getCorners() {
		System.out.println("A square has 4 points");
	}
}
