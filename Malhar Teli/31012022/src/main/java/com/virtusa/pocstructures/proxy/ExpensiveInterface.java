package com.virtusa.pocstructures.proxy;

//This interface is going to represent an object that takes a considerable amount of resources to load and store
public interface ExpensiveInterface {
    //This is the method that is *supposed* to run when the interface's inheritor is fully instantiated.
    void process();
}
