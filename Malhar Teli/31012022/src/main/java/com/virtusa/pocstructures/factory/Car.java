package com.virtusa.pocstructures.factory;

public class Car implements Vehicle{
    @Override
    public String build() {
        return "I'm a Car!";
    }
}
