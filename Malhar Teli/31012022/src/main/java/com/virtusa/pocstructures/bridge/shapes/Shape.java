package com.virtusa.pocstructures.bridge.shapes;

import com.virtusa.pocstructures.bridge.colors.Color;

public abstract class Shape {
    protected Color color;
    //This is the bridging constructor - when Shape is constructed, it receives a pre-existing Color object.

    public Shape(Color color) {
        this.color= color;
    }
    //This, of course, is the Abstract class. This means we will be defining draw in subclasses that extend shape with their own cutomized results
    abstract public String draw();
}
