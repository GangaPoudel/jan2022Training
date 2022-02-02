package com.virtusa;

public class HasPin implements ATMState {

    ATM atm;

    public HasPin(ATM newATM){

        atm = newATM;

    }

    public void insertCard() {

        System.out.println("You already entered a card");

    }

    public void ejectCard() {

        System.out.println("Your card is ejected");
        atm.setATMState(atm.getNoCardState());

    }

    public void requestCash(int cashToWithdraw) {

        if(cashToWithdraw > atm.cashInMachine){

            System.out.println("You don't have that much cash available");
            System.out.println("Your card is ejected");
            atm.setATMState(atm.getNoCardState());

        } else {

            System.out.println(cashToWithdraw + " is provided by the machine");
            atm.setCashInMachine(atm.cashInMachine - cashToWithdraw);

            System.out.println("Your card is ejected");
            atm.setATMState(atm.getNoCardState());

            if(atm.cashInMachine <= 0){

                atm.setATMState(atm.getNoCashState());

            }
        }
    }

    public void insertPin(int pinEntered) {

        System.out.println("You already entered a PIN");

    }
}
