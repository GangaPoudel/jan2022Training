package com.virtusa.creationdesignpattern.observable;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Book {
	private String title;
    private List<Liker> likers = new ArrayList<>();
    
    public Book(String title) {
    	notifyLiker(title);
    	this.title = title;
    	
    }

    public void addLiker(Liker liker) {
        this.likers.add(liker);
    }

    public void removeLikerr(Liker liker) {
        this.likers.remove(liker);
    }

    public void notifyLiker(String title) {
        
        for (Liker liker : this.likers) {
            liker.update(this.title);
        }
    }
}
