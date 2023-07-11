package org.example.ParkingLot.Entities;

import java.util.List;

public class ParkingLot {
    private final String id;
    private final int noOfFloors;
    private final int totalNoOfSlots;

    private List<Floor> floorList;
    //        ParkingLot parkingLot = new ParkingLot(tokens.get(1),noOfFloors,noOfSlots,floorList);

    public ParkingLot(String id, int noOfFloors,int totalNoOfSlots ,List<Floor> floorList) {
        this.id = id;
        this.noOfFloors = noOfFloors;
        this.totalNoOfSlots=totalNoOfSlots;
        this.floorList = floorList;
    }

    public int getTotalNoOfSlots() {
        return totalNoOfSlots;
    }

    public String getId() {

        return id;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(Floor floor) {
        this.floorList.add(floor);
    }
}