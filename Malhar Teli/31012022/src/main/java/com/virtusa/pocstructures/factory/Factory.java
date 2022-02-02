package com.virtusa.pocstructures.factory;

import com.virtusa.pocstructures.singleton.Singleton;

public class Factory {
    public Singleton singleton = Singleton.getInstance();

    public Vehicle getVehicle (String vehicleType){
        if (vehicleType.equalsIgnoreCase("CAR")) {
            return new Car();
        }
        if (vehicleType.equalsIgnoreCase("MOPED")){
            return new Moped();
        }
        if (vehicleType.equalsIgnoreCase("MOTORCYCLE")){
            return new Motorcycle();
        }
        else return null;
    }
}
