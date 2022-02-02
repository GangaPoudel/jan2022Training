package com.virtusa;

public class HasCard implements ATMState {

    ATM atm;

    public HasCard(ATM newATM){

        atm = newATM;

    }

    public void insertCard() {

        System.out.println("You can only insert one card at a time");

    }

    public void ejectCard() {

        System.out.println("Your card is ejected");
        atm.setATMState(atm.getNoCardState());

    }

    public void requestCash(int cashToWithdraw) {

        System.out.println("You have not entered your PIN");


    }

    public void insertPin(int pinEntered) {

        if(pinEntered == 1234){

            System.out.println("You entered the correct PIN");
            atm.correctPinEntered = true;
            atm.setATMState(atm.getHasPin());

        } else {

            System.out.println("You entered the wrong PIN");
            atm.correctPinEntered = false;
            System.out.println("Your card is ejected");
            atm.setATMState(atm.getNoCardState());

        }
    }
}