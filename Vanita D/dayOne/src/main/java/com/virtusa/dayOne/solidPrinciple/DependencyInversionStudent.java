package com.virtusa.dayOne.solidPrinciple;

import lombok.Data;



@Data
public class DependencyInversionStudent {
	private LiskovCollege college;

	public DependencyInversionStudent() {
		this.college = new LiskovCollege();
	}
	//By declaring the LiskovCollege with the new keyword, we've tightly coupled these two classes together.	

	public DependencyInversionStudent(LiskovCollege collegeName) {
		this.college = collegeName;
	}
		
	
}
//here the problem is college name is going to stay same always, we should pass college name as parameter, if in future student changes college
//The principle of dependency inversion refers to the decoupling of software modules. 
//This way, instead of high-level modules depending on low-level modules, both will depend on abstractions.