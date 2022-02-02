package com.virtusa.pocstructures.proxy;

import com.virtusa.pocstructures.singleton.Singleton;

public class Proxy implements ExpensiveInterface{
    //This is here to demonstrate Singleton's functionality. Please see Single.java for more info.
    public Singleton singleton = Singleton.getInstance();

    private static ExpensiveInterface object;
    //With this version of process, we ensure that process is only called from a single instance of the expensive object
    //With this example, we demonstrate both a Protection Proxy (because the initialConfiguration is scoped to a single Class)
    // and a Virtual Proxy (as Expensive Object is supposedly quite heavy, and this implementation treats it as a singleton)
    @Override
    public void process() {
        if (object == null){
            object = new ExpensiveObject();
        }
        object.process();
    }
}
