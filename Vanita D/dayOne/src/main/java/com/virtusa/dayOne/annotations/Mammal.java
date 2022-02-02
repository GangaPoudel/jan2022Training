package com.virtusa.dayOne.annotations;

import org.springframework.stereotype.Component;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


//for getter and setter, to string , equals,  @data
//@NoArgsConstructor for default constructor
//@AllArgsConstructor for all parameterized constructor
//component replace bean in xml file
@NoArgsConstructor
@AllArgsConstructor
@Data 
@Component
public class Mammal {
	private String species;
}

