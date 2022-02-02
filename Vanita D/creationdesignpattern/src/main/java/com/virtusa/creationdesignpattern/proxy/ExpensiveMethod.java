package com.virtusa.creationdesignpattern.proxy;

public interface ExpensiveMethod {
	public abstract void sayHello();
}
//allows to create an intermediary that acts as an interface to another resource and also hides complexity
//we only want to initialize objecys on demand and once they are , we would like to reuse it for all the calls
//when we want a simplified version of compleax or heavy object or when it is present somewher else and we want to use it locally
// we want to add a layer of security -protection proxy
