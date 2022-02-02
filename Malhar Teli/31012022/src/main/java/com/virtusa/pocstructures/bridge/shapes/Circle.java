package com.virtusa.pocstructures.bridge.shapes;

import com.virtusa.pocstructures.bridge.colors.Color;

public class Circle extends Shape {

    public Circle(Color color){
        super(color);
    }
    //This Circle has its own custom draw method, but it receives the color from its superconstructor.
    //This demonstrates that Circle's relationship with shape is loosely coupled, due the fact that its methods are essentially separate implementations
    @Override
    public String draw() {
        return "This Circle "+ this.color.fill();
    }
}
