package org.example.ParkingLot;

import org.example.ParkingLot.Repository.FloorRepository;
import org.example.ParkingLot.Repository.IFloorRepository;
import org.example.ParkingLot.Repository.IParkingRepository;
import org.example.ParkingLot.Repository.ParkingRepository;
import org.example.ParkingLot.Services.DisplayService;
import org.example.ParkingLot.Services.IDisplayService;
import org.example.ParkingLot.Services.IparkingService;
import org.example.ParkingLot.Services.parkingServices;
import org.example.ParkingLot.commands.*;

public class AppConfiguration {
    //making singleton class to have just one reference of it in whole application process
    private static AppConfiguration appConfiguration ;

    private  AppConfiguration(){
    }
    IParkingRepository parkingRepository = new ParkingRepository();
    IFloorRepository floorRepository = new FloorRepository();
    IparkingService parkingService = new parkingServices(parkingRepository,floorRepository);
    IDisplayService displayService = new DisplayService(parkingRepository,parkingService);

    Icommand createParkingLot = new createParkingLotCommand(parkingService);
    Icommand parkVehicle = new parkVehicleCommand(parkingService);
    Icommand unparkVehicle=  new unparkVehicleCommand(parkingService);
    Icommand displayCommand = new displaySlotCommand(displayService);
    CommandRegistry commandRegistry = new CommandRegistry();

    CommandRegistry getCommandRegistry(){
        commandRegistry.registerCommand("create_parking_lot",createParkingLot);
        commandRegistry.registerCommand("park_vehicle",parkVehicle);
        commandRegistry.registerCommand("unpark_vehicle",unparkVehicle);
        commandRegistry.registerCommand("display",displayCommand);
        return commandRegistry;
    }

    public  static  AppConfiguration getInstance(){
        if(appConfiguration==null){
            appConfiguration= new AppConfiguration();
        }
        return appConfiguration;

    }


}
