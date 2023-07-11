package org.example.ParkingLot.Services;

import org.example.ParkingLot.Constants;
import org.example.ParkingLot.Entities.Floor;
import org.example.ParkingLot.Entities.ParkingLot;
import org.example.ParkingLot.Entities.ParkingSlot;
import org.example.ParkingLot.Entities.VehicleType;
import org.example.ParkingLot.Repository.IParkingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DisplayService implements IDisplayService {
    IParkingRepository parkingRepository;
    IparkingService parkingService ;

    public DisplayService(IParkingRepository parkingRepository,IparkingService parkingService) {
        this.parkingRepository = parkingRepository;
        this.parkingService=parkingService;
    }

    @Override
    public void displayslots(List<String> tokens) {
        List<ParkingLot>parkingLotList = parkingRepository.getAllParkingLot();
        for(ParkingLot p :parkingLotList){
            //can add multiple of parking lots
            List<Floor>floorList = p.getFloorList();
            for (Floor floor : floorList) {
                Map<Integer, ParkingSlot> slots= (tokens.get(Constants.TWO).equals("CAR")) ? floor.getCarSlot() : (tokens.get(Constants.TWO).equals("BIKE")) ? floor.getBikeSlot() : floor.getTruckSlot();
                if(!tokens.get(Constants.ONE).equals("occupied_slots")){
                    List<Integer>freeSlots = slots.values().stream().filter(parkingSlot-> !parkingSlot.isOccupied()).map(ParkingSlot::getId).toList();
                    if(tokens.get(Constants.ONE).equals("free_count")){
                        System.out.println("No. of free slots for " + tokens.get(Constants.TWO) + " on Floor " + floor.getId() + " : " + freeSlots.size());
                    }else {
                        System.out.println("Free slots for "+tokens.get(Constants.TWO)+" on Floor "+floor.getId()+" : "+ freeSlots);
                    }
                }else {
                    List<Integer>occupiedSlots = slots.values().stream().filter(ParkingSlot::isOccupied).map(ParkingSlot::getId).toList();
                    System.out.println("Occupied slots for "+tokens.get(Constants.TWO)+ " on "+floor.getId()+" : "+occupiedSlots);
                }
            }
        }

    }


    }
