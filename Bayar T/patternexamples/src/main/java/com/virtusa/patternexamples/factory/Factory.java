package com.virtusa.patternexamples.factory;

public class Factory {
	
	public Shape getShape(String shape) {
		if(shape.toLowerCase().equals("circle")) {
			return new Circle();
		}
		else if(shape.toLowerCase().equals("square")) {
			return new Square();
		} 
		return null;
	}

}
