package com.virtusa.patternexamples.factory;

public class Circle implements Shape{
	@Override
	public void getCorners() {
		System.out.println("A circle has infinite points");
	}

}
