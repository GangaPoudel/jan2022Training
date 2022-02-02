package com.virtusa;

public class NoCard implements ATMState {

    ATM atm;

    public NoCard(ATM newATM){

        atm = newATM;

    }

    public void insertCard() {

        System.out.println("Please enter your pin");
        atm.setATMState(atm.getYesCardState());

    }

    public void ejectCard() {

        System.out.println("You didn't enter a card");

    }

    public void requestCash(int cashToWithdraw) {

        System.out.println("You have not entered your card");

    }

    public void insertPin(int pinEntered) {

        System.out.println("You have not entered your card");

    }
}