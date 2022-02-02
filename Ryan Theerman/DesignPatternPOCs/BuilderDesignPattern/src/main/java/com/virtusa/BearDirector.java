package com.virtusa;

public class BearDirector {

    private BearBuilder bearBuilder;

    public BearDirector(BearBuilder bearBuilder) {
        this.bearBuilder = bearBuilder;
    }

    public Bear getBear() {
        return this.bearBuilder.getBear();
    }

    public void makeBear() {
        this.bearBuilder.buildBearHead();
        this.bearBuilder.buildBearTorso();
        this.bearBuilder.buildBearArms();
        this.bearBuilder.buildBearLegs();
    }
}
