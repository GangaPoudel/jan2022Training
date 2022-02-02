package com.virtusa.dayOne.solidPrinciple;

import java.util.List;

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
public class LiskovCollege {
	private String name;
	private Float buildingSize;
}

//Now with the technolgoy advancement there are remote schools to, so it is hard to fix this code 
//One possible solution would be to rework our model into interfaces that take into account the online state of School.