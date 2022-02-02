package com.virtusa.dayOne.annotations;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data 
@Component
@EqualsAndHashCode(callSuper=false)
public class Dog extends Mammal{
	private String species;
}
