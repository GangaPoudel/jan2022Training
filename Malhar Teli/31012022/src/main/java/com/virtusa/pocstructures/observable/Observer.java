package com.virtusa.pocstructures.observable;

public class Observer implements ObserverInterface{

    public String observedUpdate= "Nothing observed just yet";
    @Override
    public void update(Object o) {
        this.observedUpdate = (String) o;
    }
}
