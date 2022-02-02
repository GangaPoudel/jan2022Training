package com.virtusa.pocstructures.observable;

import com.virtusa.pocstructures.singleton.Singleton;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private String updateMessage;
    private List<ObserverInterface> subscribers = new ArrayList<>();
    public Singleton singleton = Singleton.getInstance();

    public void addSubscriber(ObserverInterface subscriber){
        this.subscribers.add(subscriber);
    }

    public void removeSubscriber(ObserverInterface subscriber){
        this.subscribers.remove(subscriber);
    }

    public void setMessage(String update){
        this.updateMessage = update;
        for (ObserverInterface subscriber: this.subscribers){
            subscriber.update(this.updateMessage);
        }
    }

}
