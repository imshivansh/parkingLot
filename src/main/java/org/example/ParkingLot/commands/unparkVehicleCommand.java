package org.example.ParkingLot.commands;

import org.example.ParkingLot.Services.IparkingService;

import java.util.List;

public class unparkVehicleCommand implements  Icommand{
    IparkingService parkingService;

    public unparkVehicleCommand(IparkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Override
    public void execute(List<String> tokens) {
        parkingService.unparkVehicle(tokens);

    }
}
