package com.virtusa.dayOne.annotations;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data 
@Component
public class Human extends Mammal {
	private String race;
}
