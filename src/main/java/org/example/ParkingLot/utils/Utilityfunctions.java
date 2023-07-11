package org.example.ParkingLot.utils;

import org.example.ParkingLot.Constants;
import org.example.ParkingLot.Entities.Floor;
import org.example.ParkingLot.Entities.VehicleType;

public class Utilityfunctions {
    public static  void setNoOfSlotAvailable(VehicleType vehicleType,Floor floor, String typeOfOperation){
        if(typeOfOperation.equals("Increment")){
            if (vehicleType.equals(VehicleType.CAR)) {
                floor.setNoOfCarSlots(floor.getNoOfCarSlots() + Constants.ONE);
            } else {
                if (vehicleType.equals(VehicleType.BIKE)) {
                    floor.setNoOfBikeSlots(floor.getNoOfBikeSlots() + Constants.ONE);
                } else {
                    floor.setNoOfTruckSlots(floor.getNoOfTruckSlots() + Constants.ONE);
                }
            }


        }else{
            if ((vehicleType.equals(VehicleType.CAR))) {
                floor.setNoOfCarSlots(floor.getNoOfCarSlots() - Constants.ONE);
            } else {
                if (vehicleType.equals(VehicleType.BIKE)) {
                    floor.setNoOfBikeSlots(floor.getNoOfBikeSlots() - Constants.ONE);
                } else {
                    floor.setNoOfTruckSlots(floor.getNoOfTruckSlots() - Constants.ONE);
                }
            }


        }
    }
}
