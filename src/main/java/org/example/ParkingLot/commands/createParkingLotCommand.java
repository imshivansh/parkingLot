package org.example.ParkingLot.commands;

import org.example.ParkingLot.Services.IparkingService;

import java.util.List;

public class createParkingLotCommand implements Icommand{
    IparkingService parkingService;

    public createParkingLotCommand(IparkingService parkingService) {
        this.parkingService = parkingService;
    }

    @Override
    public void execute(List<String> tokens) {
        parkingService.createParkingLot(tokens);
    }
}
