package com.virtusa.pocstructures.bridge.shapes;

import com.virtusa.pocstructures.bridge.colors.Color;

public class Square extends Shape{
    public Square(Color color){
        super(color);
    }

    //The Square's Draw method is different from Circle's Draw method. This is because the abstract class they both attend is decoupled from their definitions.
    @Override
    public String draw() {
        return "This Square " + this.color.fill();
    }
}
