package com.virtusa.dayOne.solidPrinciple;

import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//for getter and setter, to string , equals,  @data
//@NoArgsConstructor for default constructor
//@AllArgsConstructor for all parameterized constructor
//component replace bean in xml file


@NoArgsConstructor
@AllArgsConstructor
@Data 
@Component
public class SingleResponsibiltityCollege {
	private String name;
	private int studentCount;
	private String principalName;
	
	public void getAllStudentName() {
		//here we have to find all Students
		//then get all Students Name
		//print the name of student;
		System.out.println("");
	}
}
//Single Responsibility
//Testing – A class with one responsibility will have far fewer test cases.
//Lower coupling – Less functionality in a single class will have fewer dependencies.
//Organization – Smaller, well-organized classes are easier to search than monolithic ones.
//We should implement a seprate class to print all StudentName
//
//public class Student {
//	private String Name;
//	
//}