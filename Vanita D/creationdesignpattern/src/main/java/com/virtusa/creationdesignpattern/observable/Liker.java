package com.virtusa.creationdesignpattern.observable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Liker {
	private String name;
	
	public void update(String s) {
		System.out.println(this.name +" : "  + s +" has been published");
	}
}
