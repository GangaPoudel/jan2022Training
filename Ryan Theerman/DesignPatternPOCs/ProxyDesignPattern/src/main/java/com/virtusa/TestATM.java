package com.virtusa;

public class TestATM {

    public static void main(String[] args){

        ATM atm = new ATM();

        atm.insertCard();

        atm.ejectCard();

        atm.insertCard();

        atm.insertPin(1234);

        atm.requestCash(2000);

        atm.insertCard();

        atm.insertPin(1234);

        GetATMData realATM = new ATM();

        GetATMData atmProxy = new ATMProxy();

        System.out.println("\nCurrent ATM State " + atmProxy.getATMData());

        System.out.println("\nCash in ATM $" + atmProxy.getCashInMachine());

    }
}