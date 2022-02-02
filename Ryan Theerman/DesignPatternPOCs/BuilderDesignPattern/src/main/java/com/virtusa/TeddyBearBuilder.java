package com.virtusa;

public class TeddyBearBuilder implements BearBuilder{

    private Bear bear;

    public TeddyBearBuilder() {
        this.bear = new Bear();
    }

    @Override
    public void buildBearHead() {
        bear.setBearHead("Smiling Head");
    }

    @Override
    public void buildBearTorso() {
        bear.setBearTorso("Furry Torso");
    }

    @Override
    public void buildBearArms() {
        bear.setBearArms("Long Arms");
    }

    @Override
    public void buildBearLegs() {
        bear.setBearLegs("Skinny Legs");
    }

    public Bear getBear() {
        return this.bear;
    }
}
