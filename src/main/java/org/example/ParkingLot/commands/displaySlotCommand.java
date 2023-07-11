package org.example.ParkingLot.commands;

import org.example.ParkingLot.Repository.IParkingRepository;
import org.example.ParkingLot.Services.IDisplayService;
import org.example.ParkingLot.Services.IparkingService;

import java.util.List;

public class displaySlotCommand implements Icommand{
    IDisplayService displayService;

    public displaySlotCommand(IDisplayService displayService) {
        this.displayService = displayService;
    }

    @Override
    public void execute(List<String> tokens) {
        displayService.displayslots(tokens);

    }
}
