package com.virtusa;

public class ATMProxy implements GetATMData{
    @Override
    public ATMState getATMData() {
        ATM realATM = new ATM();
        return realATM.getATMData();
    }

    @Override
    public int getCashInMachine() {
        ATM realATM = new ATM();
        return realATM.getCashInMachine();
    }
}
