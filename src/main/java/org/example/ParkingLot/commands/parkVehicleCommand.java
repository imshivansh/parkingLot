package org.example.ParkingLot.commands;

import org.example.ParkingLot.Services.IparkingService;

import java.util.List;

public class parkVehicleCommand implements  Icommand{
    IparkingService parkingService;

    public parkVehicleCommand(IparkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Override
    public void execute(List<String> tokens) {
        parkingService.parkVehicle(tokens);

    }
}
