package com.virtusa.pocstructures.singleton;

//In this example, I will create a singleton. Ordinarily, we could simple annotate this as a Bean, but that is Spring's autowiring methodology
//Instead I will simply create this class as needed.
public class Singleton {
    // This here is a random number we will reference in every call of this singleton.
    private double randomNumber = Math.random()*100.0;

    //This will be our instance.
    private static Singleton instance = new Singleton();

    //By making the construct private, we remove the possiblity of any other script attempting to construct a singleton.
    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }

    public double getRandomNumber(){
        return randomNumber;
    }

}
