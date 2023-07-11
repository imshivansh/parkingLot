package org.example.ParkingLot.Services;

import org.example.ParkingLot.Constants;
import org.example.ParkingLot.Entities.*;
import org.example.ParkingLot.Repository.IFloorRepository;
import org.example.ParkingLot.Repository.IParkingRepository;
import org.example.ParkingLot.Repository.ITicketRepository;
import org.example.ParkingLot.Repository.TicketRepository;
import org.example.ParkingLot.utils.Utilityfunctions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class parkingServices implements  IparkingService {
    IParkingRepository parkingRepository;
    IFloorRepository floorRepository;
    ITicketRepository ticketRepository;
    IFloorService floorService;
    public parkingServices(IParkingRepository parkingRepository,IFloorRepository floorRepository) {
        this.parkingRepository = parkingRepository;
        this.floorRepository=floorRepository;
        ticketRepository = new TicketRepository();
        this.floorService =  new FloorService();
    }

    @Override
    public void createParkingLot(List<String> tokens) {
        //create_parking_lot PR1234 2 6
        int noOfSlots = Integer.parseInt(tokens.get(Constants.THREE));
        int noOfFloors = Integer.parseInt(tokens.get(Constants.TWO));
        List<Floor>floorList = floorService.createAndSaveFloor(noOfSlots,noOfFloors,tokens.get(Constants.ONE));
        ParkingLot parkingLot = new ParkingLot(tokens.get(1),noOfFloors,noOfSlots,floorList);
        parkingRepository.addParkingLot(parkingLot);
        if(parkingRepository.getParkingLotById(tokens.get(1))!=null){
            System.out.println("Created parking lot with "+ parkingLot.getNoOfFloors()+ " floors and "+ parkingLot.getTotalNoOfSlots()+" slots per floor"
            );
        }else{
            throw new RuntimeException("Internal error,please try again later");
        }

    }



    @Override
    public void parkVehicle(List<String> tokens) {
        //•	park_vehicle <vehicle_type> <reg_no> <color>
        /*
        we will consider we have no opf parking lots and if they present we ll go ascending order wise to check whether first lot has the space and each lot can have number
        of floors and each floors has no of slots , so if one floor does not have the slot then program should automatically go up and check if there are slots available and if searching through
        all the floors, slots are not available for a particular type of vehicle then we ll go n check on another parking lot if we have

         */
        List<ParkingLot> parkingLotList = parkingRepository.getAllParkingLot();
        String vehicleType = tokens.get(Constants.ONE);
        String[] allVehicleTypes = {"CAR","TRUCK","BIKE"};
        Ticket vehicleTicket = null;

        for(int t =Constants.ZERO;t<allVehicleTypes.length;t++) {
        String typeOfVehicle = allVehicleTypes[t];
            if(vehicleType.equals(typeOfVehicle)){
                for(int i =Constants.ZERO;i<parkingLotList.size();i++){
                    //iterating each parking lot availability for slots on each floor
                    ParkingLot parkingLot = parkingLotList.get(i);
                    String parkingLotId = parkingLot.getId();
                    List<Floor>floorList = parkingLot.getFloorList();
                    for(int j=Constants.ZERO;j<floorList.size();j++){
                        //iterating through each floor to check if we have the slots available
                        Floor floor = floorList.get(j);
                        Integer floorId = floor.getId();
                        int noOfSlotsAvailableForGivenVehicleType = (typeOfVehicle.equals("CAR"))?floor.getNoOfCarSlots():(typeOfVehicle.equals("BIKE"))?floor.getNoOfBikeSlots():floor.getNoOfTruckSlots();
                        // we will only move forward if we have slots available for the given vehicle type, if not then we ll go and check on another floor
                        if(noOfSlotsAvailableForGivenVehicleType>=Constants.ONE){
                            //here we know that there are slots available but we also need to iterate through slots to check which one is not occupied
                            Map<Integer,ParkingSlot>parkingSlots = (typeOfVehicle.equals("CAR"))?floor.getCarSlot():(typeOfVehicle.equals("BIKE"))?floor.getBikeSlot():floor.getTruckSlot();
                        vehicleTicket=  checkAvailableSlotAndCreateNSaveTicket(floorId,parkingLotId,parkingSlots,vehicleTicket,tokens,floor);
                        }
                        //if slot is found then it means we have created the ticket and we dont have to iterate further we ll simply break the loop
                         if(vehicleTicket!=null){
                            break;
                           }
                    }
                    //no need to iterate through further parking lot if we found the match
                      if(vehicleTicket!=null)break;
                }
                //no need to iterate further to check for other type since the ticket is found along with vehicle type match
                 if(vehicleTicket!=null)break;
            }
        }
        if(vehicleTicket!=null){
            System.out.println( "Parked vehicle. Ticket ID: "+vehicleTicket.getTicketId());
        }else{
            System.out.println("Parking Lot full");
        }
    }

    @Override
    public void unparkVehicle(List<String> tokens) {
        // Parked vehicle. Ticket ID: PR1234_1_4
        String ticketId = tokens.get(Constants.ONE);
        Ticket ticket = ticketRepository.getTicketById(ticketId);
        if(ticket!=null){
            String parkingLotId = ticket.getParkingLotId();
            ParkingLot parkingLot = parkingRepository.getParkingLotById(parkingLotId);
            List<Floor>floorList = parkingLot.getFloorList();
            Floor floor = floorList.stream().filter(f->f.getId()==ticket.getFloorNo()).findAny().get();
            VehicleType vehicleType = ticket.getVehicle().getVehicleType();
            Map<Integer,ParkingSlot>vehicleTypeSlot = (vehicleType==VehicleType.BIKE)?floor.getBikeSlot():(vehicleType==VehicleType.CAR)?floor.getCarSlot():floor.getTruckSlot();
            ParkingSlot parkingSlot=vehicleTypeSlot.get(ticket.getSlotNo());
            //uparked the vehicle and released the slot
            parkingSlot.setOccupied(false);
            //incremented the no of slot available for given type
            Utilityfunctions.setNoOfSlotAvailable(vehicleType,floor,Constants.INCREMENT);
            ticketRepository.deleteTicket(ticketId);
            System.out.println("Unparked vehicle with Registration Number: "+ticket.getVehicle().getRegisterNo()+" and Color "+ticket.getVehicle().getColor());

        }else{
            System.out.println("Invalid Ticket");
        }

    }
    private Ticket checkAvailableSlotAndCreateNSaveTicket(Integer floorId, String parkingLotId, Map<Integer, ParkingSlot> parkingSlots, Ticket vehicleTicket, List<String> tokens, Floor floor) {
        for(Map.Entry<Integer,ParkingSlot>entry:parkingSlots.entrySet()){
            ParkingSlot p = entry.getValue();
            Integer slotNo = entry.getKey();
            if(!p.isOccupied()){
                Vehicle vehicle = new Vehicle(tokens.get(Constants.TWO),tokens.get(Constants.THREE),VehicleType.CAR);
                String ticketId = parkingLotId+"_"+floorId.toString()+"_"+slotNo.toString();
                Ticket ticket = new Ticket(ticketId,parkingLotId,floorId,slotNo,vehicle);
                ticket = ticketRepository.saveTicket(ticketId,ticket);
                vehicleTicket=ticket;
                p.setTicket(ticket);
                p.setVehicle(vehicle);
                p.setOccupied(true);
                //decrement the available vehicle slot
                Utilityfunctions.setNoOfSlotAvailable(vehicle.getVehicleType(),floor,Constants.DECREMENT);
                break;
            }
        }
        return vehicleTicket;

    }

}
