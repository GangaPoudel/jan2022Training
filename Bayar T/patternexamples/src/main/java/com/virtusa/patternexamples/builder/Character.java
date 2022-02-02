package com.virtusa.patternexamples.builder;

public class Character {
	private int id;
	private String name;
	private int strength;
	
	public Character setId(int id) {
		this.id = id;
		return this;
	}
	
	public Character setName(String name) {
		this.name = name;
		return this;
	}
	
	public Character setStrength(int strength) {
		this.strength = strength;
		return this;
	}
	
	public void printAll() {
		System.out.println(id + " " + name + " " + strength);
	}

}
