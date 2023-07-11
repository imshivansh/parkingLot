package org.example.ParkingLot.Entities;

public class Vehicle {
    private final String registerNo;
    private final String color;
    private final VehicleType vehicleType;

    public Vehicle(String registerNo, String color, VehicleType vehicleType) {
        this.registerNo = registerNo;
        this.color = color;
        this.vehicleType=vehicleType;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getRegisterNo() {
        return this.registerNo;
    }

    public String getColor() {
        return color;
    }

}
