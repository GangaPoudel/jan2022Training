package com.virtusa.pocstructures.proxy;

public class ExpensiveObject implements ExpensiveInterface{

    //In the factory method, this class will call upon an expensive method that will take a lot of resources.
    //By doing this during the instantiation phase, we can safely run any code requiring it after the process is complete
    public ExpensiveObject(){
        intialConfiguration();
    }


    //This method will be called after the instantiation to ensure that the resource is given the necessary time to load.
    @Override
    public void process() {
        System.out.println("Processing complete");
    }

    //This method will be used to process the data required for the object's instantiation.
    //By doing this, we canuse the sensitive data required by our instantiation without exposing it beyond the scope
    // of this class.
    private void intialConfiguration(){
        System.out.println("Loading intial configuration...");
    }
}
