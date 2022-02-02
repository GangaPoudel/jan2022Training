package com.virtusa;

public class TestBearBuilder {

    public static void main(String[] args) {

        BearBuilder teddyBear = new TeddyBearBuilder();

        BearDirector bearDirector = new BearDirector(teddyBear);

        bearDirector.makeBear();

        Bear firstBear = bearDirector.getBear();

        System.out.println("Bear built!");

        System.out.println("Bear Head Type: " + firstBear.getBearHead());
        System.out.println("Bear Torso Type: " + firstBear.getBearTorso());
        System.out.println("Bear Arms Type: " + firstBear.getBearArms());
        System.out.println("Bear Legs Type: " + firstBear.getBearLegs());

    }
}
