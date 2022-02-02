package com.virtusa;

public class Bear implements BearPlan{

    private String bearHead;
    private String bearTorso;
    private String bearArms;
    private String bearLegs;

    @Override
    public void setBearHead(String head) {
        this.bearHead = head;
    }

    public String getBearHead() {
        return bearHead;
    }

    @Override
    public void setBearTorso(String torso) {
        this.bearTorso = torso;
    }

    public String getBearTorso() {
        return bearTorso;
    }

    @Override
    public void setBearArms(String arms) {
        this.bearArms = arms;
    }

    public String getBearArms() {
        return bearArms;
    }

    @Override
    public void setBearLegs(String legs) {
        this.bearLegs = legs;
    }

    public String getBearLegs() {
        return bearLegs;
    }
}
