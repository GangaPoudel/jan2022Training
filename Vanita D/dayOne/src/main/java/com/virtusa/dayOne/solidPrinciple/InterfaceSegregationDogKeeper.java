package com.virtusa.dayOne.solidPrinciple;

public interface InterfaceSegregationDogKeeper {
	void DogFeeder();
	void DogWalker();
	void DogLover();
}
//public class DogCarer implements DogFeeder {
//
//    public void dogFeeder() {
//        System.out.println("cookie");
//    }
//
//   
//}
//And finally, we can leave the dogperson  to the  person:
//
//public class DogPerson implements DogWalker, DogLover {
//
//    public void dogWalker() {
//        System.out.println("PErson is walking the dog");
//    }
//	 public void dogLover() {
//		 System.out.println("Person loves the dog");
//	}
//}
//larger interfaces should be split into smaller ones. 
// we can ensure that implementing classes only need to be concerned about the methods that are of interest to them.