package com.ganga.factory;

public class FactoryPattern {

	public Vehicle getwheel(Integer wheelnumber) {
		if (wheelnumber.equals(null)) {
			return null;
		} else if (wheelnumber.equals(2)) {
			return new Motocycle();
		} else if (wheelnumber.equals(4)) {
			return new Car();
		}
		return null;

	}
	public static void main(String[] args) {
		FactoryPattern factoryPattern = new FactoryPattern();
		Vehicle car = factoryPattern.getwheel(4);
		car.wheel();
		Vehicle motorcycle = factoryPattern.getwheel(2);
		motorcycle.wheel();
		
		
	}

}
